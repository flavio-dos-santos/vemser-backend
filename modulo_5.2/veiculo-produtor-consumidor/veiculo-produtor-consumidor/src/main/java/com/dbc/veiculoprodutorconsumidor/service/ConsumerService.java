package com.dbc.veiculoprodutorconsumidor.service;

import com.dbc.veiculoprodutorconsumidor.Entity.VeiculoEntity;
import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.veiculoprodutorconsumidor.repository.VeiculoRepository;
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

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final VeiculoRepository veiculoRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic}", // nome do topico
            groupId = "group",
            containerFactory = "listenerContainerFactory")
    public void informacaoConsumidor(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        VeiculoDTO veiculoDTO = objectMapper.readValue(message, VeiculoDTO.class);
        insertOne(veiculoDTO);
        System.out.println(veiculoDTO);
        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, veiculoDTO);
    }

    public VeiculoDTO insertOne(VeiculoDTO veiculo){
        VeiculoEntity veiculoEntity = objectMapper.convertValue(veiculo, VeiculoEntity.class);
        veiculoEntity.setDataLeitura(LocalDateTime.now());
        VeiculoDTO veiculoDTO = objectMapper.convertValue(veiculoRepository.save(veiculoEntity), VeiculoDTO.class);
        return veiculoDTO;
    }

    public Double mediaVelocidade()throws Exception{
        return veiculoRepository.findAll().stream()
                .mapToDouble(veiculo -> veiculo.getVelocidade())
                .average()
                .orElseThrow();
    }

    public Double mediaRotacao()throws Exception{
        return veiculoRepository.findAll().stream()
                .mapToDouble(veiculo -> veiculo.getRotacao())
                .average()
                .orElseThrow();
    }

    public Long quantidadeLeituras(){
        return (long) veiculoRepository.findAll().size();
    }
}
