package br.com.dbc.vemser.pessoaapi.repository;


import br.com.dbc.vemser.pessoaapi.entity.pessoa.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
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



}