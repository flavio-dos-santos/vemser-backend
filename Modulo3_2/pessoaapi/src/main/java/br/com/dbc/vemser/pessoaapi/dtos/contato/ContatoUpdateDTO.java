package br.com.dbc.vemser.pessoaapi.dtos.contato;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoUpdateDTO extends ContatoCreateDTO {
    @ApiModelProperty(value = "IdPessoa do contato")
    @NotNull
    private Integer idPessoa;
}
