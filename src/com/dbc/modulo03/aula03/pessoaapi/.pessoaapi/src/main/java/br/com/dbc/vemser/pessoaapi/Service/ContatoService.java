package br.com.dbc.vemser.pessoaapi.Controller.Service;

import br.com.dbc.vemser.pessoaapi.Controller.Entidades.Contato;
import br.com.dbc.vemser.pessoaapi.Controller.Repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

//    public ContatoService(){
//        contatoRepository = new ContatoRepository();
//    }

    public Contato create(Integer id, Contato contato){
        return contatoRepository.create(id, contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizado) throws Exception{
        return contatoRepository.update(id, contatoAtualizado);
    }

    public Contato delete(Integer id) throws Exception{
        return contatoRepository.delete(id);
    }

    public List<Contato> listByIdPessoa(Integer id){
        return contatoRepository.listByIdPessoa(id);
    }
}
