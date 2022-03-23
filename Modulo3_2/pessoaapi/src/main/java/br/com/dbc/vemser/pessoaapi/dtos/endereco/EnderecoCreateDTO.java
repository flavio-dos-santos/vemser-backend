package br.com.dbc.vemser.pessoaapi.dtos.endereco;

import br.com.dbc.vemser.pessoaapi.entity.endereco.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.entity.pessoa.PessoaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {
    @ApiModelProperty(value = "tipo do endereço")

    @NotNull
    private TipoEndereco tipo;

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

    @JsonIgnore
    // muitos endereços para muitas pessoas
    @ManyToMany(mappedBy = "enderecos")
    private Set<PessoaEntity> pessoas;
}
