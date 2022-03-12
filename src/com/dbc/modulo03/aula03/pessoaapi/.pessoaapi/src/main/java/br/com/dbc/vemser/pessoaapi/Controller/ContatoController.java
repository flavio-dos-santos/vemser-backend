package br.com.dbc.vemser.pessoaapi.Controller;

import br.com.dbc.vemser.pessoaapi.Controller.Entidades.Contato;
import br.com.dbc.vemser.pessoaapi.Controller.Service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato") //localhost:8080/contato
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

//    public ContatoController(){
//        contatoService = new ContatoService();
//    }

    @PostMapping("/{idPessoa}")
    public Contato create(@PathVariable("idPessoa") Integer id, @RequestBody Contato contato){
        return contatoService.create(id, contato);
    }

    @GetMapping
    public List<Contato> list(){
        return contatoService.list();
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,@RequestBody Contato contatoAtualizado) throws Exception{
        return contatoService.update(id, contatoAtualizado);
    }

    @DeleteMapping("/{idContato}")
    public Contato delete(@PathVariable("idContato") Integer id) throws Exception{
        return contatoService.delete(id);
    }

    @GetMapping("/{byIdPessoa}")
    public List<Contato> listByIdPessoa(@RequestParam("idPessoa") Integer id){
        return contatoService.listByIdPessoa(id);
    }
}
