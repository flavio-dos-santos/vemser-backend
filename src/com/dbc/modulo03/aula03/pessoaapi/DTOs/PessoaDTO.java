package br.com.dbc.vemser.pessoaapi.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO extends PessoaCreateDTO {
    private Integer idPessoa;
}
