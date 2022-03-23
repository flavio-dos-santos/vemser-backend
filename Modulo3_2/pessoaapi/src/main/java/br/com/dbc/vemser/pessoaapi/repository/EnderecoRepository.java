package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.endereco.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity,Integer> {


    @Query("select e " +
            "   from ENDERECO_PESSOA e " +
            " where e.pais = :pais" )
    List<EnderecoEntity> findByPaisJPQL(String pais);


    @Query("select e "+
            "from ENDERECO_PESSOA e "+
            "join fetch e.pessoas p "+
            "   where p.idPessoa = :idPessoa")
    List<EnderecoEntity> findByEnderecosComIdPessoaJPQL(Integer idPessoa);

    @Query(value = "SELECT * " +
        "   FROM VEM_SER.ENDERECO_PESSOA e "+
        "   WHERE e.cidade = :cidade OR e.pais = :pais", nativeQuery = true)
    List<EnderecoEntity> findByCidadeOrPaisSQLNativo(String cidade ,String pais);


    @Query(value = "SELECT * "+
        "FROM VEM_SER.ENDERECO_PESSOA e "+
        "WHERE e.complemento IS NULL", nativeQuery = true)
    List<EnderecoEntity> findByEnderecosSemComplementoSQLNativo();
}
