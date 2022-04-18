package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.contato.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.contato.TipoContato;
import br.com.dbc.vemser.pessoaapi.entity.endereco.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    @Query("select c "+
            "   from CONTATO c "+
            "   where c.tipoContato = :tipoContato")
    List<ContatoEntity> findByTipoContatoJPQL(TipoContato tipoContato);

    @Query(value = "select * "+
            "from VEM_SER.CONTATO c "+
            "where c.idPessoa = :idPessoa", nativeQuery = true)
    List<ContatoEntity> findByContatoIdPessoaSQLNativo (Integer idPessoa);


    @Query("select c "+
        "   from CONTATO c "+
        "   where c.descricao = :descricao")
    Page<ContatoEntity> findAllPagEOrdenPorDesc(String descricao, Pageable pageable);
}




