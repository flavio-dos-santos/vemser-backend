package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.dtos.pessoa.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dtos.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
@RequiredArgsConstructor
public class PessoaService {


    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

//public PessoaService(){
//    pessoaRepository = new PessoaRepository();
//}

    public PessoaDTO create(PessoaCreateDTO pessoaCreate) throws Exception {
        log.info("chamou o método create Pessoa!");

        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreate, PessoaEntity.class);
        PessoaEntity pessoaEntityCriada = pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntityCriada, PessoaDTO.class);
        return pessoaDTO;
    }


    public List<PessoaDTO> list(){
        log.info("chamou o método list Pessoa!");

        return  pessoaRepository.findAll()
                .stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
    }


public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
    log.info("chamou o método update Pessoa!");

    PessoaEntity pessoaEncontrada = pessoaRepository.findById(id)
            .orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada"));
    pessoaEncontrada.setCpf(pessoaAtualizar.getCpf());
    pessoaEncontrada.setNome(pessoaAtualizar.getNome());
    pessoaEncontrada.setEmail(pessoaAtualizar.getEmail());
    pessoaEncontrada.setDataNascimento(pessoaAtualizar.getDataNascimento());

    //tem que dar o find no id da pessoa e set para poder dar o save!
    PessoaEntity pessoaEntityAtt = pessoaRepository.save(pessoaEncontrada);
    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntityAtt, PessoaDTO.class);


    return pessoaDTO;
}

public PessoaDTO delete(Integer id) throws Exception{
    log.info("chamou o método delete Pessoa!");

    PessoaEntity pessoaEncontrada = pessoaRepository.findById(id)
            .orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada"));
    pessoaRepository.delete(pessoaEncontrada);
    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEncontrada, PessoaDTO.class);

    return pessoaDTO;
}

//public Optional<PessoaDTO> listByName(String name){
//    log.info("chamou o método listByName Pessoa!");
//    return pessoaRepository.findOne()
//            .stream()
//            .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
//            .findFirst();
//}

public PessoaDTO getById(Integer id) throws Exception {
    log.info("chamou o método getById Pessoa!");
    PessoaEntity pessoaEntity = pessoaRepository.findById(id)
            .orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada"));
    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

    return pessoaDTO;
}

}


