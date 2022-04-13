package com.dbc.chatkafka.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String usuario;
    private String mensagem;
    private LocalDateTime dataCriacao;
}
