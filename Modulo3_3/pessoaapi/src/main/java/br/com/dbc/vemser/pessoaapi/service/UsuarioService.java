package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dtos.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.usuario.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO create(LoginDTO newUsuario) throws RegraDeNegocioException {
        log.info("chamou o método create Usuário!!");
    UsuarioEntity usuarioEntity = objectMapper.convertValue(newUsuario, UsuarioEntity.class);
    usuarioEntity.setSenha(new BCryptPasswordEncoder().encode(usuarioEntity.getPassword()));
    UsuarioEntity senhaCryp = usuarioRepository.save(usuarioEntity);
    LoginDTO loginDTO = objectMapper.convertValue(senhaCryp, LoginDTO.class);
    return loginDTO;
    }
}