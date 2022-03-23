package br.com.dbc.vemser.pessoaapi.entity.endereco;

import br.com.dbc.vemser.pessoaapi.entity.pessoa.PessoaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco_contato", allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idEndereco;
//    private Integer idPessoa;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo")
    private TipoEndereco tipo;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private int numero;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "pais")
    private String pais;

    @JsonIgnore
    // muitos endereços para muitas pessoas
    @ManyToMany(mappedBy = "enderecos")
    private Set<PessoaEntity> pessoas;


//    public Endereco(Integer idEndereco, Integer idPessoa , String tipo, String logradouro, int numero,String cep, String cidade, String estado, String pais){
//        this.idEndereco = idEndereco;
//        this.idPessoa = idPessoa;
//        this.tipo = tipo;
//        this.logradouro =  logradouro;
//        this.numero = numero;
//        this.cep = cep;
//        this.cidade = cidade;
//        this.estado = estado;
//        this.pais = pais;
//    }
//
//    public Integer getIdEndereco() {
//        return idEndereco;
//    }
//
//    public void setIdEndereco(Integer idEndereco) {
//        this.idEndereco = idEndereco;
//    }
//
//    public Integer getIdPessoa() {
//        return idPessoa;
//    }
//
//    public void setIdPessoa(Integer idPessoa) {
//        this.idPessoa = idPessoa;
//    }
//
//    public String getLogradouro() {
//        return logradouro;
//    }
//
//    public void setLogradouro(String logradouro) {
//        this.logradouro = logradouro;
//    }
//
//    public int getNumero() {
//        return numero;
//    }
//
//    public void setNumero(int numero) {
//        this.numero = numero;
//    }
//
//    public String getCidade() {
//        return cidade;
//    }
//
//    public void setCidade(String cidade) {
//        this.cidade = cidade;
//    }
//
//    public String getEstado() {
//        return estado;
//    }
//
//    public void setEstado(String estado) {
//        this.estado = estado;
//    }
//
//    public String getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(String tipo) {
//        this.tipo = tipo;
//    }
//
//    public String getCep() {
//        return cep;
//    }
//
//    public void setCep(String cep) {
//        this.cep = cep;
//    }
//
//    public String getPais() {
//        return pais;
//    }
//
//    public void setPais(String pais) {
//        this.pais = pais;
//    }
//
//    @Override
//    public String toString() {
//        return "Endereco{" +
//                "idEndereco=" + idEndereco +
//                ", idPessoa=" + idPessoa +
//                ", tipo='" + tipo + '\'' +
//                ", logradouro='" + logradouro + '\'' +
//                ", numero=" + numero +
//                ", cep='" + cep + '\'' +
//                ", cidade='" + cidade + '\'' +
//                ", estado='" + estado + '\'' +
//                ", pais='" + pais + '\'' +
//                '}';
//    }
}
