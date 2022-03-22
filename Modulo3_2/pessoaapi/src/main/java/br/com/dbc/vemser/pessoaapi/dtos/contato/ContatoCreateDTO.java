package br.com.dbc.vemser.pessoaapi.dtos.contato;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContatoCreateDTO {

    @ApiModelProperty(value = "tipo de contato")
    @NotNull
    private String tipoContato;
    @ApiModelProperty(value = "numero do contato")
    @NotEmpty
    @Size(min=9, max=13)
    private String numero;
    @ApiModelProperty(value = "descrição do contato")
    @NotEmpty
    private String descricao;
}
