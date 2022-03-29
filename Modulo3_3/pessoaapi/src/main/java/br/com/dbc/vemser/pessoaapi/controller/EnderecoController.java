package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dtos.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dtos.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.endereco.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private EnderecoRepository enderecoRepository;


    @ApiOperation(value = "Retornar uma lista de endereços")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "lista de endereços"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<EnderecoDTO> listarTodos(){
        return enderecoService.listarTodos();
    }

    @ApiOperation(value = "Retornar um endereço pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "listar endereco pelo id"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{idEndereco}")
    public EnderecoDTO getByIdEndereco(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.getByIdEndereco(id);
    }


//    CORRIGIR O IDPESSOA
//    @ApiOperation(value = "Retornar endereços por id da pessoa")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "listar endereço com id da pessoa"),
//            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
//    })
//    @GetMapping("/{idPessoa}/pessoa")
//    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer id){
//        return enderecoService.listByIdPessoa(id);
//    }

    @ApiOperation(value = "Retornar um endereço criado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "endereço criado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping("/{idPessoa}")
    @Validated
    public ResponseEntity<EnderecoDTO> create (@PathVariable("idPessoa") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
                return ResponseEntity.ok(enderecoService.create(id,endereco));
    }

    @ApiOperation(value = "Retornar um endereço atualizado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "endereço atualizado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{idEndereco}")
    @Validated
    public EnderecoDTO update(@PathVariable("idEndereco")Integer id,@Valid @RequestBody EnderecoCreateDTO enderecoAtualizado) throws Exception{
        return enderecoService.update(id,enderecoAtualizado);
    }


    @ApiOperation(value = "Retornar um endereco deletado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "listar endereco deletado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{idEndereco}")
    public EnderecoDTO delete(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.delete(id);
    }


    //fins didaticos

    @ApiOperation(value = "Retornar um endereco pelo pais")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "listar endereco pelo pais"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/endereco-por-pais")
    List<EnderecoEntity> findByPaisJPQL(@RequestParam(value = "pais") String pais){
        return enderecoRepository.findByPaisJPQL(pais);
    }


    @ApiOperation(value = "Retornar um endereco pelo idPessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "listar endereco pelo idPessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/enderecos-com-id-pessoa")
    List<EnderecoEntity> findByEnderecosComIdPessoaJPQL(@RequestParam(value = "idPessoa") Integer idPessoa){
        return enderecoRepository.findByEnderecosComIdPessoaJPQL(idPessoa);
    }

    @ApiOperation(value = "Retornar um endereco pela cidade ou pais")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "listar endereco  pela cidade ou pais"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/listar-enderecos-por-pais-ou-cidade")
    List<EnderecoEntity> findByCidadeOrPaisSQLNativo(@RequestParam(value = "cidade") String cidade ,
                                                     @RequestParam(value = "pais")String pais){
        return enderecoRepository.findByCidadeOrPaisSQLNativo(cidade,pais);
    }
    @GetMapping("/endereco-sem-complemento")
    List<EnderecoEntity> findByEnderecosSemComplementoSQLNativo(){
        return enderecoRepository.findByEnderecosSemComplementoSQLNativo();
    }


}
