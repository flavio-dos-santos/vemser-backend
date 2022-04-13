package com.dbc.veiculoprodutorconsumidor.dto;

import java.time.LocalDateTime;

public class VeiculoCreateDTO {
    private LocalDateTime dataLeitura;
    private Double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}
