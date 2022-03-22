package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.com.dbc.vemser.pessoaapi.dto.Sexo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoaisDTO {
    private String nome;
    private String cpf;
    private String rg;
    private String cnh;
    private String nomeMae;
    private String nomePai;
    private String tituloEleitor;
    private Sexo sexo;
}
