package com.parkcollab.backend.controller;

import com.parkcollab.backend.domain.error.ErrorResponse;
import com.parkcollab.backend.domain.estacionamento.Estacionamento;
import com.parkcollab.backend.domain.estacionamento.EstacionamentoRequest;
import com.parkcollab.backend.service.Estacionamento.EstacionamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

    private static Logger logger = LoggerFactory.getLogger(EstacionamentoController.class);

    private final EstacionamentoService estacionamentoService;

    public EstacionamentoController(EstacionamentoService estacionamentoService) {
        this.estacionamentoService = estacionamentoService;
    }

    @PostMapping
    ResponseEntity saveEstacionamento(@RequestBody EstacionamentoRequest estacionamentoRequest){
        try{
            Estacionamento estacionamento = estacionamentoService.create(estacionamentoRequest);

            if(estacionamento == null) throw new RuntimeException();

            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("ERRO AO CADASTRAR ESTACIONAMENTO --------------- {}", e.getMessage());
            return ResponseEntity.internalServerError().body(new ErrorResponse("Erro ao cadastrar estacionamento, tente novamente mais tarde"));
        }
    }

}
