package br.com.dbc.vemser.pessoaapi.dtos.contato;


import br.com.dbc.vemser.pessoaapi.dtos.contato.ContatoCreateDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContatoDTO extends ContatoCreateDTO {
    @ApiModelProperty(value = "Id do contato")
    private Integer idContato;
}
