package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.pk.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorRepository professorRepository;

@GetMapping
    public List<ProfessorEntity> list(){
        return professorRepository.findAll();
    }

@PostMapping()
    public ProfessorEntity create(@RequestBody ProfessorEntity professorEntity) throws Exception{
        return professorRepository.save(professorEntity);
    }
}


