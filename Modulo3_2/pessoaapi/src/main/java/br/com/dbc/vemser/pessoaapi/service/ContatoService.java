package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dtos.contato.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dtos.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dtos.pessoa.PessoaDTOComContatos;
import br.com.dbc.vemser.pessoaapi.entity.pessoa.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import br.com.dbc.vemser.pessoaapi.entity.contato.ContatoEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
@RequiredArgsConstructor
public class ContatoService {


    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

//    public ContatoService(){
//        contatoRepository = new ContatoRepository();
//    }


public ContatoDTO create(Integer id, ContatoCreateDTO contatoCreate) throws Exception {
    log.info("chamou o método create Contato!");

    pessoaRepository.findById(id)
            .orElseThrow(()-> new RegraDeNegocioException("esta pessoa não existe"));
    ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreate, ContatoEntity.class);
    contatoEntity.setIdPessoa(id);
    ContatoEntity contatoEntityCriado = contatoRepository.save(contatoEntity);
    ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntityCriado, ContatoDTO.class);

    return contatoDTO;
}


    public List<ContatoDTO> list(){
        log.info("chamou o método list Contato!");
        return contatoRepository.findAll()
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizado) throws Exception{
        log.info("chamou o método update Contato!");
         ContatoEntity contatoEncontrado = contatoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException(" id de contato invalido!"));
        contatoEncontrado.setTipoContato(contatoAtualizado.getTipo());
        contatoEncontrado.setDescricao(contatoAtualizado.getDescricao());
        contatoEncontrado.setNumero(contatoAtualizado.getNumero());


        ContatoEntity contatoEntityAtt = contatoRepository.save(contatoEncontrado);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntityAtt, ContatoDTO.class);

        return contatoDTO;
    }

    public ContatoDTO delete(Integer id) throws Exception{
        log.info("chamou o método delete Contato!");

        ContatoEntity contatoEntity = contatoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("Id de contato não existe!"));

        contatoRepository.delete(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }



        public ContatoDTO listByIdPessoa(Integer idPessoa)throws Exception{
            log.info("chamou o método listByIdPessoa Contato!");
            ContatoEntity contatoEntity = contatoRepository.findById(idPessoa)
                    .orElseThrow(()->new RegraDeNegocioException("id não encontrado!"));
             return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
      }


}

