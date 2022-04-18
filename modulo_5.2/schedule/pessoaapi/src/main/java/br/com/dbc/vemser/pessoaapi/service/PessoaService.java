package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.dtos.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dtos.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dtos.pessoa.*;
import br.com.dbc.vemser.pessoaapi.entity.pessoa.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
  public List<PessoaDTO> findByNomeContainingIgnoreCase(String nome)throws Exception{
        return pessoaRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
  }

  public List<PessoaDTO> findByCpf(String cpf)throws Exception{
        return pessoaRepository.findByCpf(cpf)
                .stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
  }

  public List<PessoaDTO> findByDataNascimentoBetween(LocalDate inicio, LocalDate fim)throws Exception{
          return pessoaRepository.findByDataNascimentoBetween(inicio, fim)
                  .stream()
                  .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity,PessoaDTO.class))
                  .collect(Collectors.toList());
  }

    public List<PessoaDTOComContatos> listComContatos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOComContatos> pessoaDTOList = new ArrayList<>();
        if(idPessoa == null){
            pessoaDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComContatos.class);
                        pessoaDTO.setContatos(pessoa.getContatos().stream()
                                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                .collect(Collectors.toList())
                        );

                        return pessoaDTO;
                    }).collect(Collectors.toList())
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada!"));
            PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatos.class);
            pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoaDTOList.add(pessoaDTO);
        }
        return pessoaDTOList;
    }

    public List<PessoaDTOComEndereco> listComEnderecos(Integer idPessoa) throws RegraDeNegocioException{
        List<PessoaDTOComEndereco> pessoaDTOComEnderecoList = new ArrayList<>();
        if(idPessoa == null){
            pessoaDTOComEnderecoList.addAll(pessoaRepository.findAll()
                    .stream()
                    .map(pessoaEntity -> {
                        PessoaDTOComEndereco pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComEndereco.class);
                        pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .collect(Collectors.toList())
                        );
                        return pessoaDTO;
        }).collect(Collectors.toList())
            );
    }else{
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(()-> new RegraDeNegocioException("pessoa não encontrada"));
            PessoaDTOComEndereco pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComEndereco.class);
            pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(endereco-> objectMapper.convertValue(endereco,EnderecoDTO.class))
                    .collect(Collectors.toList()));
            pessoaDTOComEnderecoList.add(pessoaDTO);
        }
        return pessoaDTOComEnderecoList;
    }


//    public PessoaEntity findById(Integer idPessoa){
//        retu
//    }


    public List<PessoaDTOComTodos> listPessoaDTOComTudo(Integer idPessoa) throws Exception{
        List<PessoaDTOComTodos> pessoaDTOComTodos = new ArrayList<>();
        if(idPessoa == null){
            pessoaDTOComTodos.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComTodos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComTodos.class);
                        pessoaDTO.setContatos(pessoa.getContatos().stream()
                                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                .collect(Collectors.toList()));
                        pessoaDTO.setEnderecos(pessoa.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .collect(Collectors.toList()));
                        return pessoaDTO;
                                    }).collect(Collectors.toList()));
                        }else{
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(()-> new RegraDeNegocioException("pessoa não encontrada"));
            PessoaDTOComTodos pessoaDTOComT = objectMapper.convertValue(pessoaEntity, PessoaDTOComTodos.class);
            pessoaDTOComT.setEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(endereco-> objectMapper.convertValue(endereco,EnderecoDTO.class))
                    .collect(Collectors.toList()));
            pessoaDTOComT.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoaDTOComTodos.add(pessoaDTOComT);
        }
        return pessoaDTOComTodos;
        }

}





