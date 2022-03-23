package br.com.dbc.vemser.pessoaapi.controller;




import br.com.dbc.vemser.pessoaapi.dtos.pessoa.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dtos.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dtos.pessoa.PessoaDTOComContatos;
import br.com.dbc.vemser.pessoaapi.dtos.pessoa.PessoaDTOComEndereco;
import br.com.dbc.vemser.pessoaapi.entity.pessoa.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa")// localhost:8080/pessoa
@Validated
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

//    public PessoaController(){
//        pessoaService = new PessoaService();
//    }

    @GetMapping("/Hello")// localhost:8080/pessoa/hello
    public String hello(){
        return "hello World!";
    }

    @ApiOperation(value = "Retorna uma pessoa criada")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criou uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping// localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

//    @ApiOperation(value = "Retornar uma pessoa por nome")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna a lista de pessoas por nome"),
//            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
//    })
//    @GetMapping("/listByName") // localhost:8080/pessoa/byname?nome=Rafa
//    public Optional<PessoaDTO> listByName(@RequestParam("nome") String nome) {
//        return pessoaService.listByName(nome);
//    }


    @ApiOperation(value = "Retornar uma pessoa Atualizada")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizou uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                 @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @ApiOperation(value = "Retornar uma pessoa deletada")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deletou uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public PessoaDTO delete(@PathVariable("idPessoa") Integer id) throws Exception {
      return  pessoaService.delete(id);
    }


    @ApiOperation(value = "Retorna uma lista de pessoas pelo nome escolhido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas pelo nome escolhido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar-por-nome")
    public List<PessoaDTO> findByNomeContainingIgnoreCase(@RequestParam(value = "nome") String nome) throws Exception{
        return pessoaService.findByNomeContainingIgnoreCase(nome);
    }



    @ApiOperation(value = "Retorna uma lista de pessoas que nasceram entre as datas escolhidas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas que nasceram entre as datas escolhidas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar-por-data-periodo")
    public List<PessoaDTO> findByDataNascimentoBetween(@RequestParam(value = "data_final") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento1,
                                            @RequestParam(value = "data_inicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento2) throws Exception{
        return pessoaService.findByDataNascimentoBetween(dataNascimento1, dataNascimento2);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas encontradas pelo CPF")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas encontradas pelo CPF"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar-por-cpf")
    public List<PessoaDTO> findByCpf(@RequestParam(value = "cpf") String cpf) throws Exception{
        return pessoaService.findByCpf(cpf);
    }

    @GetMapping("/listar-com-contatos")
    public List<PessoaDTOComContatos> listComContatos(@RequestParam(value = "id", required = false) Integer idPessoa)throws RegraDeNegocioException {
        return pessoaService.listComContatos(idPessoa);
    }

    @GetMapping("/listar-com-enderecos")
    public List<PessoaDTOComEndereco> listComEnderecos(@RequestParam(value = "id", required = false) Integer idPessoa)throws RegraDeNegocioException{
        return pessoaService.listComEnderecos(idPessoa);
    }

}
