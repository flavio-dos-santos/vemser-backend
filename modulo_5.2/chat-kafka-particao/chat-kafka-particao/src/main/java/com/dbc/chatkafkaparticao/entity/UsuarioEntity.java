package com.dbc.chatkafkaparticao.entity;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
    private String usuario;
    private String mensagem;
    private LocalDateTime dataCriacao;
}
