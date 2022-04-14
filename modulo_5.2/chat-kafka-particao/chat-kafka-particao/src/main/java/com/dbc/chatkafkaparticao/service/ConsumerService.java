package com.dbc.chatkafkaparticao.service;

import com.dbc.chatkafkaparticao.dto.UsuarioDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    private final ObjectMapper objectMapper;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    @KafkaListener(
            groupId = "flavio",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "particao",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0", "3"} )}
    )
    public void consumer(@Payload String mensagem,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID)Integer partitionID,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws JsonProcessingException {
        UsuarioDTO usuarioDTO = objectMapper.readValue(mensagem, UsuarioDTO.class);
        LocalDateTime criacaoMensagem = LocalDateTime.now();
        log.info(dateTimeFormatter.format(criacaoMensagem) + " [" + usuarioDTO.getUsuario() + "]: " + mensagem);
        log.info("#### offset -> '{}' key -> '{}' -> partition ID -> '{}' -> TOPIC -> '{}' -> MSG -> '{}'", offset, key,partitionID,topic, mensagem);
    }
}
