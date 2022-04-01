package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dtos.CadastroUsuarioDTO;
import br.com.dbc.vemser.pessoaapi.dtos.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.GrupoEntity;
import br.com.dbc.vemser.pessoaapi.entity.usuario.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.GrupoRepository;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final GrupoService grupoService;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO create(CadastroUsuarioDTO newUsuario) throws Exception {
        log.info("chamou o método create Usuário!!");
    UsuarioEntity usuarioEntity = objectMapper.convertValue(newUsuario, UsuarioEntity.class);
    usuarioEntity.setSenha(new BCryptPasswordEncoder().encode(usuarioEntity.getPassword()));
        usuarioEntity.setGrupos(newUsuario.getIdGrupos().stream().map(grupo -> {

            try {
                return grupoService.getById(grupo).orElse(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toSet()));
    UsuarioEntity senhaCryp = usuarioRepository.save(usuarioEntity);
    LoginDTO loginDTO = objectMapper.convertValue(senhaCryp, LoginDTO.class);
    return loginDTO;
    }
}