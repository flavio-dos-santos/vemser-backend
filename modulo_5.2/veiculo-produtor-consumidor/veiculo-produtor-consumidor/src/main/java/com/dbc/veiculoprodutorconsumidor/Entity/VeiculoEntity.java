package com.dbc.veiculoprodutorconsumidor.Entity;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "sensorveiculo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoEntity {
    @Id
    String idVeiculo;
    LocalDateTime dataLeitura;
    Double velocidade;
    Integer rotacao;
    boolean sensorFrenagem;
}
