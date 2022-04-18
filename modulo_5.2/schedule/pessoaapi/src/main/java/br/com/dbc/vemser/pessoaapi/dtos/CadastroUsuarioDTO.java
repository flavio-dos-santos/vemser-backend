package br.com.dbc.vemser.pessoaapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CadastroUsuarioDTO {
    @NotNull
    private String login;
    @NotNull
    private String senha;
    private Set<String> gruposTipo;
}
