package com.dbc.veiculoprodutorconsumidor.controller;


import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.veiculoprodutorconsumidor.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;


    @PostMapping("/enviar-sensor")
    public void enviarMensagemSensor(@RequestBody VeiculoDTO veiculoDTO) throws JsonProcessingException{
        produtorService.enviarMensagemSensor(veiculoDTO);
    }

}

