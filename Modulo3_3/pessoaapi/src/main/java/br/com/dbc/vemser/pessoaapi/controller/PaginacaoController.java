package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.contato.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.endereco.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {
    private final PessoaRepository pessoaRepository;
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;


    @GetMapping("/contatos-ordenados-descricao")
    public Page<ContatoEntity> findAllPagEOrdenPorDesc(Integer paginaSolicitada, Integer tamanhoDaPagina){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina, Sort.by("descricao").ascending());
        Page<ContatoEntity> all = contatoRepository.findAll(pageable);
        return all;
    }

    @GetMapping("/enderecos-ordenados-cep")
    public Page<EnderecoEntity> findAllPagEOrdenPorCep(Integer paginaSolicitada, Integer tamanhoDaPagina){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina, Sort.by("cep").ascending());
        Page<EnderecoEntity> all = enderecoRepository.findAll(pageable);
        return all;
    }

    @GetMapping("/enderecos-filtrado-pais")
    public Page<EnderecoEntity> findAllPagEFiltradaPorPais(Integer paginaSolicitada, Integer tamanhoDaPagina,String pais){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina);
        Page<EnderecoEntity> all = enderecoRepository.findAllPagEFiltradaPorPais(pais,pageable);
        return all;
    }
}
