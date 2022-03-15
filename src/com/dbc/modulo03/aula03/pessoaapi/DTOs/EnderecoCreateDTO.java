package br.com.dbc.vemser.pessoaapi.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class EnderecoCreateDTO {

    private Integer idPessoa;
    @NotNull
    private String tipo;
    @NotEmpty
    @Size(min = 1, max = 250)
    private String logradouro;
    @NotNull
    @Min(1)
    private int numero;
    @NotEmpty
    @Size(min=1,max=8)
    private String cep;
    @NotEmpty
    @Size(min = 1,max=250)
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;
}
