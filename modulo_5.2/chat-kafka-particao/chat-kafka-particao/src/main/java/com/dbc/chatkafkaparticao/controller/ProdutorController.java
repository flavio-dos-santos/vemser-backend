package com.dbc.chatkafkaparticao.controller;


import com.dbc.chatkafkaparticao.dto.UsuarioDTO;
import com.dbc.chatkafkaparticao.enums.NomesChats;
import com.dbc.chatkafkaparticao.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    private void enviar(@RequestBody UsuarioDTO usuarioDTO, @RequestParam List<NomesChats> chats) throws JsonProcessingException {

        produtorService.enviarMensagem(usuarioDTO, chats );
    }
}

