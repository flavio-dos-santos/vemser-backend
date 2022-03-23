package br.com.dbc.vemser.pessoaapi.repository;


import br.com.dbc.vemser.pessoaapi.entity.contato.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.contato.TipoContato;
import br.com.dbc.vemser.pessoaapi.entity.endereco.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.endereco.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.entity.pessoa.PessoaEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity,Integer> {
    //Listar pessoa pelo nome e ignorando a caixa
    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);

    //Listar por cpf
    List<PessoaEntity> findByCpf(String cpf);

    //Listar data de nascimento depois da data
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate inicio, LocalDate fim);


    @Query("select p "+
        "   from PESSOA p "+
        "   where p.dataNascimento between :dataInicio And :dataFim")
    List<PessoaEntity> findByDataNascimentoBetweenJPQL(@Param("dataInicio") LocalDate dataInicio,@Param("dataFim") LocalDate dataFim);

    @Query("select p "+
        "   from PESSOA p "+
        "   join fetch p.enderecos e "+
        "   where e.tipo = :tipo")
    List<PessoaEntity> findByPessoaComEnderecoJPQL(TipoEndereco tipo);

    @Query(value = "SELECT * "+
        "FROM VEM_SER.PESSOA p "+
        "LEFT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO a "+
        "ON p.ID_PESSOA = a.ID_PESSOA "+
        "WHERE a.ID_PESSOA IS NULL",nativeQuery = true)
    List<PessoaEntity> findByPessoaSemEnderecoSQLNativo();
}