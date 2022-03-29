package br.com.dbc.vemser.pessoaapi.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {
    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    private String senha;
}