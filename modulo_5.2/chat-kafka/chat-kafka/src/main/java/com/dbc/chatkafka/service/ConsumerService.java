package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.UsuarioDTO;
import com.dbc.chatkafka.enums.NomesChats;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
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
            topics = "${kafka.topic.geral}", // topico geral
            groupId = "flavio",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "geral")
    public void consumerGeral(@Payload String mensagem,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        UsuarioDTO usuarioDTO = objectMapper.readValue(mensagem, UsuarioDTO.class);
        LocalDateTime criacaoMensagem = LocalDateTime.now();
        log.info(dateTimeFormatter.format(criacaoMensagem) + " [" + usuarioDTO.getUsuario() + "]: " + mensagem);
        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, mensagem);
    }

    @KafkaListener(
            topics = "${kafka.topic.privado}", // topico privado
            groupId = "flavio",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "privado")
    public void consumerPrivado(@Payload String mensagem,
                                @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        UsuarioDTO usuarioDTO = objectMapper.readValue(mensagem, UsuarioDTO.class);
        LocalDateTime criacaoMensagem = LocalDateTime.now();
        log.info(dateTimeFormatter.format(criacaoMensagem) + " [" + usuarioDTO.getUsuario() + "](privado): " + usuarioDTO.getMensagem());
        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, mensagem);
    }


}
