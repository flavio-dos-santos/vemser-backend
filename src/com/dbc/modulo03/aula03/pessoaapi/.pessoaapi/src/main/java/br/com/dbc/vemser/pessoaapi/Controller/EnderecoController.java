package br.com.dbc.vemser.pessoaapi.Controller;

import br.com.dbc.vemser.pessoaapi.Entidades.Endereco;
import br.com.dbc.vemser.pessoaapi.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listarTodos(){
        return enderecoService.listarTodos();
    }

    @GetMapping("/{idEndereco}")
    public Endereco getByIdEndereco(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.getByIdEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer id){
        return enderecoService.listByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    public Endereco create (@PathVariable("idPessoa") Integer id,@RequestBody Endereco endereco){
        endereco.setIdPessoa(id);
        return enderecoService.create(endereco);
    }

    @PutMapping("/idEndereco")
    public Endereco update(@PathVariable("idEndereco")Integer id,@RequestBody Endereco enderecoAtualizado) throws Exception{
        return enderecoService.update(id,enderecoAtualizado);
    }

    @DeleteMapping("/{idEndereco}")
    public Endereco delete(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.delete(id);
    }


}
