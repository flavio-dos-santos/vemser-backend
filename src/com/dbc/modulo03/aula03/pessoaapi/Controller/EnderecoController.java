package br.com.dbc.vemser.pessoaapi.Controller;

import br.com.dbc.vemser.pessoaapi.Entidades.Endereco;
import br.com.dbc.vemser.pessoaapi.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @Validated
    public ResponseEntity<Endereco> create (@PathVariable("idPessoa") Integer id, @Valid @RequestBody Endereco endereco) throws Exception {
                return ResponseEntity.ok(enderecoService.create(id,endereco));
    }

    @PutMapping("/{idEndereco}")
    @Validated
    public Endereco update(@PathVariable("idEndereco")Integer id,@Valid @RequestBody Endereco enderecoAtualizado) throws Exception{
        return enderecoService.update(id,enderecoAtualizado);
    }

    @DeleteMapping("/{idEndereco}")
    public Endereco delete(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.delete(id);
    }


}
