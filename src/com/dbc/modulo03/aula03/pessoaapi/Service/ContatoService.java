package br.com.dbc.vemser.pessoaapi.Service;

import br.com.dbc.vemser.pessoaapi.Controller.Entidades.Contato;
import br.com.dbc.vemser.pessoaapi.Exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.Repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

//    public ContatoService(){
//        contatoRepository = new ContatoRepository();
//    }

    public Contato create(Integer id, Contato contato) throws Exception {
           pessoaRepository.getById(id);
        return contatoRepository.create(id, contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizado) throws Exception{
        pessoaRepository.getById(id);
        return contatoRepository.update(id, contatoAtualizado);
    }

    public Contato delete(Integer id) throws Exception{
        return contatoRepository.delete(id);
    }

    public List<Contato> listByIdPessoa(Integer id){
        return contatoRepository.listByIdPessoa(id);
    }
}
