package br.com.dbc.vemser.pessoaapi.Controller;




import br.com.dbc.vemser.pessoaapi.DTOs.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.DTOs.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.Entidades.Pessoa;
import br.com.dbc.vemser.pessoaapi.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @PostMapping// localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @GetMapping("/listByName") // localhost:8080/pessoa/byname?nome=Rafa
    public Optional<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }


    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                 @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public PessoaDTO delete(@PathVariable("idPessoa") Integer id) throws Exception {
      return  pessoaService.delete(id);
    }



}
