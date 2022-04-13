package com.dbc.chatkafka.controller;


import com.dbc.chatkafka.dto.UsuarioDTO;
import com.dbc.chatkafka.enums.NomesChats;
import com.dbc.chatkafka.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    private void enviar(@RequestBody UsuarioDTO usuarioDTO, @RequestParam("chats")NomesChats chats) throws JsonProcessingException {
        produtorService.enviarMensagem(usuarioDTO, chats);
    }
}

