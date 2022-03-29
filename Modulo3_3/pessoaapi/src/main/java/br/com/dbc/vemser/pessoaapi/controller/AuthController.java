package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.dtos.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.usuario.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.security.TokenService;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {
        Optional<UsuarioEntity> usuarioBuscado = usuarioService.findByLoginAndSenha(loginDTO.getLogin(), loginDTO.getSenha());
        if(usuarioBuscado.isPresent()){
            return tokenService.getToken(usuarioBuscado.get());
        } else {
            throw new RegraDeNegocioException("Usuario e senha inválidos!");
        }
    }

}
