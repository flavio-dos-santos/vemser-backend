package br.com.dbc.vemser.pessoaapi.Repository;

import br.com.dbc.vemser.pessoaapi.Entidades.Endereco;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository(){
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),1,"qno 30 conjunto k",456,"taguatinga","DF"));
    }

    public List<Endereco> listarTodos(){
        return listaEnderecos;
    }

    public Endereco getByIdEndereco(Integer id) throws Exception{
        return listaEnderecos.stream()
                .filter(end -> end.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("ID inválido!"));
    }

    public List<Endereco> listByIdPessoa(Integer id){
        return listaEnderecos.stream()
                .filter(end -> end.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public Endereco create(Endereco endereco){
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public Endereco update(Integer id, Endereco enderecoAtualizado) throws Exception{
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(()-> new Exception("Endereço inválido!"));
        enderecoRecuperado.setIdPessoa(enderecoAtualizado.getIdPessoa());
        enderecoRecuperado.setLogradouro(enderecoAtualizado.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizado.getNumero());
        enderecoRecuperado.setCidade(enderecoAtualizado.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizado.getEstado());

        return enderecoRecuperado;
    }

    public Endereco delete(Integer id) throws Exception{
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(()-> new Exception("Endereço Inválido!"));

        return enderecoRecuperado;
    }
}
