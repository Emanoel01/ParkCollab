package com.parkcollab.backend.controller;

import com.parkcollab.backend.domain.error.ErrorResponse;
import com.parkcollab.backend.domain.funcionario.Funcionario;
import com.parkcollab.backend.domain.funcionario.FuncionarioRequest;
import com.parkcollab.backend.service.Funcionario.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }


    @GetMapping("/{id}")
    public ResponseEntity getFuncionarios(@PathVariable Integer id){
        try{


            if(id < 10) return ResponseEntity.badRequest().body(new ErrorResponse("ID menor que 10"));


            return ResponseEntity.badRequest().body(new Funcionario());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody FuncionarioRequest funcionarioRequest){
        try{
            Funcionario funcionario = funcionarioService.createFuncionario(funcionarioRequest);

            if(funcionario == null) throw new RuntimeException("Erro ao criar funcionario");


            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            if(e instanceof RuntimeException)
                return ResponseEntity.badRequest().body(ErrorResponse.builder().message(e.getMessage()).build());

            return ResponseEntity.internalServerError().build();
        }

    }

}
