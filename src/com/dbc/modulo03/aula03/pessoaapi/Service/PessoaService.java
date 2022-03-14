package br.com.dbc.vemser.pessoaapi.Service;


import br.com.dbc.vemser.pessoaapi.Entidades.Pessoa;
import br.com.dbc.vemser.pessoaapi.Repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

//public PessoaService(){
//    pessoaRepository = new PessoaRepository();
//}

public Pessoa create(Pessoa pessoa){
//    try {
//        if(StringUtils.isBlank(pessoa.getNome())) {
//            throw new Exception("O nome não pode ficar em branco!");
//        }
//
//        if(ObjectUtils.isEmpty(pessoa.getDataNascimento())){
//            throw new Exception( "Não pode inserir pessoa sem data de nascimento!");
//        }
//
//        if (StringUtils.length(pessoa.getCpf())!= 11) {
//            throw new Exception( "O cpf tem que conter 11 digitos!");
//        }
//
//        return pessoaRepository.create(pessoa);
//    }catch (Exception e){
//        System.out.println(e.getMessage());
//    }
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

public Pessoa getById(Integer id) throws Exception {
        return pessoaRepository.getById(id);
    }

}


