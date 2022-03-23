package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dtos.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dtos.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.endereco.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public List<EnderecoDTO> listarTodos(){
        log.info("chamou o método listarTodos Endereco!");
        return enderecoRepository.findAll()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO getByIdEndereco(Integer id) throws Exception{
        log.info("chamou o método getByIdEndereco Endereco!");
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRepository.findById(id), EnderecoDTO.class);
        return enderecoDTO;
    }
//              Não sei arrumar o id pessoa, perguntar ou pesquisar
//    public List<EnderecoDTO> listByIdPessoa(Integer id){
//        log.info("chamou o método listByIdPessoa Endereco!");
//        return enderecoRepository.findById(id)
//                .stream()
//                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
//                .collect(Collectors.toList());
//    }

    public EnderecoDTO create(Integer id , @Valid EnderecoCreateDTO enderecoCreate)throws Exception{
        log.info("chamou o método create Endereco!");

        pessoaRepository.getById(id);
        EnderecoEntity enderecoEntityCriado = objectMapper.convertValue(enderecoCreate, EnderecoEntity.class);
        EnderecoEntity enderecoEntity = enderecoRepository.save(enderecoEntityCriado);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);

        return enderecoDTO;
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizado)throws Exception{
        log.info("chamou o método update Endereco!");

        EnderecoEntity enderecoEncontrado =enderecoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("endereço nao encontrado"));
        enderecoEncontrado.setCep(enderecoAtualizado.getCep());
        enderecoEncontrado.setCidade(enderecoAtualizado.getCidade());
        enderecoEncontrado.setEstado(enderecoAtualizado.getEstado());
        enderecoEncontrado.setLogradouro(enderecoAtualizado.getLogradouro());
        enderecoEncontrado.setNumero(enderecoAtualizado.getNumero());
        enderecoEncontrado.setPais(enderecoAtualizado.getPais());
        enderecoEncontrado.setTipo(enderecoAtualizado.getTipo());

        EnderecoEntity enderecoEntityAtt = enderecoRepository.save(enderecoEncontrado);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntityAtt, EnderecoDTO.class);

        return enderecoDTO;
    }

    public EnderecoDTO delete(Integer id) throws Exception{
        log.info("chamou o método delete Endereco!");

        EnderecoEntity enderecoEncontrado = enderecoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("endereço não encontrado!"));
       enderecoRepository.delete(enderecoEncontrado);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEncontrado, EnderecoDTO.class);

        return enderecoDTO;
    }
}
