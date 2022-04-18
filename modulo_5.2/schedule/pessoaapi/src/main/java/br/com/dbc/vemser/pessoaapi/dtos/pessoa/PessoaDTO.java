package br.com.dbc.vemser.pessoaapi.dtos.pessoa;

import br.com.dbc.vemser.pessoaapi.dtos.pessoa.PessoaCreateDTO;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaDTO extends PessoaCreateDTO {
    private Integer idPessoa;
}
