package br.com.dbc.vemser.pessoaapi.Service;

import br.com.dbc.vemser.pessoaapi.Entidades.Pessoa;
import br.com.dbc.vemser.pessoaapi.Repository.PessoaRepository;

import java.util.List;

public class PessoaService {
    private PessoaRepository pessoaRepository;

public PessoaService(){
    pessoaRepository = new PessoaRepository();
}

public Pessoa create(Pessoa pessoa){
    return pessoaRepository.create(pessoa);
}

public List<Pessoa> list(){
    return pessoaRepository.list();
}

public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws Exception {
    return pessoaRepository.update(id,pessoaAtualizar);
}

public Pessoa delete(Integer id) throws Exception{
    return pessoaRepository.delete(id);
}

public List<Pessoa> listByName(String name){
    return pessoaRepository.listByName(name);
}
}
