package br.com.dbc.vemser.pessoaapi.dtos.pessoa;

import br.com.dbc.vemser.pessoaapi.dtos.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dtos.endereco.EnderecoDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTOComTodos extends PessoaCreateDTO {
    @ApiModelProperty(value = "Lista de contatos da pessoa")
    private List<ContatoDTO> contatos;
    @ApiModelProperty(value = "Lista de enderecos da pessoa")
    private List<EnderecoDTO> enderecos;
}
