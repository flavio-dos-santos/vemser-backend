package br.com.dbc.vemser.pessoaapi.dtos.endereco;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {
    @ApiModelProperty(value = "tipo do endereço")
    @NotNull
    private String tipo;

    @ApiModelProperty(value = "logradouro")
    @NotEmpty
    @Size(min = 1, max = 250)
    private String logradouro;

    @ApiModelProperty(value = "numero do endereço")
    @NotNull
    @Min(1)
    private int numero;

    @ApiModelProperty(value = "cep")
    @NotEmpty
    @Size(min = 1,max=8)
    private String cep;

    @ApiModelProperty(value = "cidade")
    @NotEmpty
    @Size(min = 1, max=250)
    private String cidade;

    @ApiModelProperty(value = "estado")
    @NotNull
    private String estado;

    @ApiModelProperty(value = "pais")
    @NotNull
    private String pais;
}
