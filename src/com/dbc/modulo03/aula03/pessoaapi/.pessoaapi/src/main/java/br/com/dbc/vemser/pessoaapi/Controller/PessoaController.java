package br.com.dbc.vemser.pessoaapi.Controller;


import br.com.dbc.vemser.pessoaapi.Entidades.Pessoa;
import br.com.dbc.vemser.pessoaapi.Service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")// localhost:8080/pessoa
public class PessoaController {
    private PessoaService pessoaService;

    public PessoaController(){
        pessoaService = new PessoaService();
    }

    @GetMapping("/Hello")// localhost:8080/pessoa/hello
    public String hello(){
        return "hello World!";
    }

    @PostMapping// localhost:8080/pessoa
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaService.create(pessoa);
    }

    @GetMapping // localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }


    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

}