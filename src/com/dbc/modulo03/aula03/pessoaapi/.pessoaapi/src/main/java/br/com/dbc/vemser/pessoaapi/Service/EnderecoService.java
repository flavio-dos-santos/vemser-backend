package br.com.dbc.vemser.pessoaapi.Service;

import br.com.dbc.vemser.pessoaapi.Entidades.Endereco;
import br.com.dbc.vemser.pessoaapi.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarTodos(){
        return enderecoRepository.listarTodos();
    }

    public Endereco getByIdEndereco(Integer id) throws Exception{
        return enderecoRepository.getByIdEndereco(id);
    }

    public List<Endereco> listByIdPessoa(Integer id){
        return enderecoRepository.listByIdPessoa(id);
    }

    public Endereco create(Endereco endereco){
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer id, Endereco enderecoAtualizado)throws Exception{
        return enderecoRepository.update(id,enderecoAtualizado);
    }

    public Endereco delete(Integer id) throws Exception{
        return enderecoRepository.delete(id);
    }
}
