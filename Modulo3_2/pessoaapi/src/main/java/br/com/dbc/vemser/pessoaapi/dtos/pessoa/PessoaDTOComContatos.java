package br.com.dbc.vemser.pessoaapi.dtos.pessoa;

import br.com.dbc.vemser.pessoaapi.dtos.contato.ContatoDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PessoaDTOComContatos extends PessoaCreateDTO {
    private Integer idPessoa;
    private List<ContatoDTO> contatos;

}
