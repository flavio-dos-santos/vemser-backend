package br.com.dbc.vemser.pessoaapi.dtos.pessoa;

import br.com.dbc.vemser.pessoaapi.dtos.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dtos.endereco.EnderecoDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PessoaDTOComEndereco extends PessoaCreateDTO {
    private Integer idPessoa;
    private List<EnderecoDTO> enderecos;

}
