package br.com.dbc.vemser.pessoaapi.entity.pessoa;

import br.com.dbc.vemser.pessoaapi.entity.contato.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.endereco.EnderecoEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name="DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name= "cpf")
    String cpf;

    @Column(name= "EMAIL")
    private String email;

    //CASO  O FILHO NAÔ TENHA MAIS RELAÇÂO COM QUALQUER CLASSE PAI, ELE SE ALTO REMOVE(SENDO orphanRemoval = true)
    @JsonIgnore
    // uma pessoa, muitos contatos
    @OneToMany(mappedBy="pessoaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContatoEntity> contatos;

    // colocar @JsongIgnore para nao ficar em loop infinito, uma tabela buscando dentro de outra
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "Pessoa_X_Pessoa_Endereco",
        joinColumns = @JoinColumn(name = "id_pessoa"),
        inverseJoinColumns = @JoinColumn(name= "id_endereco")
)
    private Set<EnderecoEntity> enderecos;
}
