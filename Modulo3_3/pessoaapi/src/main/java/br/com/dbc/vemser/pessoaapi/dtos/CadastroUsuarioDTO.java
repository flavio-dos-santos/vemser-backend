package br.com.dbc.vemser.pessoaapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CadastroUsuarioDTO {
    private String login;
    private String senha;
    private Set<Integer> idGrupos;
}
