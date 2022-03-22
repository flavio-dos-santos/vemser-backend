package br.com.dbc.vemser.pessoaapi.dtos.endereco;



import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO extends EnderecoCreateDTO {
    @ApiModelProperty(value = "Id do endereço")
    private Integer idEndereco;
}
