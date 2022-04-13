package com.dbc.veiculoprodutorconsumidor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {

    Double velocidade;
    Integer rotacao;
    boolean sensorFrenagem;
}
