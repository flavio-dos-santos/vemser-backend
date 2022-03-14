package br.com.dbc.vemser.pessoaapi.Service;

import br.com.dbc.vemser.pessoaapi.Entidades.Endereco;
import br.com.dbc.vemser.pessoaapi.Repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Endereco> listarTodos(){
        return enderecoRepository.listarTodos();
    }

    public Endereco getByIdEndereco(Integer id) throws Exception{
        return enderecoRepository.getByIdEndereco(id);
    }

    public List<Endereco> listByIdPessoa(Integer id){
        return enderecoRepository.listByIdPessoa(id);
    }

    public Endereco create(Integer id ,Endereco endereco)throws Exception{
        pessoaRepository.getById(id);
        return enderecoRepository.create(id,endereco);
    }

    public Endereco update(Integer id, Endereco enderecoAtualizado)throws Exception{
        pessoaRepository.getById(id);
        return enderecoRepository.update(id,enderecoAtualizado);
    }

    public Endereco delete(Integer id) throws Exception{
        return enderecoRepository.delete(id);
    }
}
