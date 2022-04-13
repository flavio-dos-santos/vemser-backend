package com.dbc.veiculoprodutorconsumidor.controller;

import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.veiculoprodutorconsumidor.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Consumer")
@RequiredArgsConstructor
public class ConsumerController {
    private final ConsumerService consumerService;


    @PostMapping("/inserir")
    public VeiculoDTO insertOne(@RequestBody VeiculoDTO veiculo){
        return consumerService.insertOne(veiculo);
    }

    @GetMapping("/media-velocidade")
    public Double mediaVelocidade()throws Exception{
        return consumerService.mediaVelocidade();
    }
    @GetMapping("/media-rotacao")
    public Double mediaRotacao()throws Exception{
        return consumerService.mediaRotacao();
    }

    @GetMapping("/quantidade-leituras")
    public Long quantidadeLeituras(){
        return consumerService.quantidadeLeituras();
    }
}
