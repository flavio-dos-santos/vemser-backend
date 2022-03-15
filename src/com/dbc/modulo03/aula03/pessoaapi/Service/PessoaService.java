package br.com.dbc.vemser.pessoaapi.Service;


import br.com.dbc.vemser.pessoaapi.DTOs.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.DTOs.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.Entidades.Pessoa;
import br.com.dbc.vemser.pessoaapi.Repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;

//public PessoaService(){
//    pessoaRepository = new PessoaRepository();
//}

    public PessoaDTO create(PessoaCreateDTO pessoaCreate) throws Exception {
        log.info("chamou o método create Pessoa!");

        Pessoa pessoa = objectMapper.convertValue(pessoaCreate, Pessoa.class);

        Pessoa pessoaCriada = pessoaRepository.create(pessoa);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        return pessoaDTO;
    }


    public List<PessoaDTO> list(){
        log.info("chamou o método list Pessoa!");
        return pessoaRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }


public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
    log.info("chamou o método update Pessoa!");
    Pessoa pessoa = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);

    Pessoa pessoaAtt = pessoaRepository.update(id,pessoa);

    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaAtt, PessoaDTO.class);

    return pessoaDTO;
}

public PessoaDTO delete(Integer id) throws Exception{
    log.info("chamou o método delete Pessoa!");

    Pessoa pessoaDeletada = pessoaRepository.delete(id);

    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaDeletada, PessoaDTO.class);

    return pessoaDTO;
}

public Optional<PessoaDTO> listByName(String name){
    log.info("chamou o método listByName Pessoa!");
    return pessoaRepository.listByName(name)
            .stream()
            .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
            .findFirst();
}

public PessoaDTO getById(Integer id) throws Exception {
    log.info("chamou o método getById Pessoa!");

    Pessoa pessoaCriada = pessoaRepository.getById(id);

    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

    return pessoaDTO;
}

}


