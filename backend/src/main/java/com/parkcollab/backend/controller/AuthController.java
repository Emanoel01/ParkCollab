package com.parkcollab.backend.controller;

import com.parkcollab.backend.domain.login.Login;
import com.parkcollab.backend.domain.login.LoginRequest;
import com.parkcollab.backend.domain.login.LoginResponse;
import com.parkcollab.backend.service.config.authentication.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    private static Logger logger = LoggerFactory.getLogger(EstacionamentoController.class);

    @PostMapping
    private ResponseEntity login(@RequestBody LoginRequest loginRequest){
        try{
            var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((Login) auth.getPrincipal());

            return ResponseEntity.ok().body(LoginResponse.builder().token(token).build());
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
