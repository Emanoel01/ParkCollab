package com.parkcollab.backend.service.Funcionario;

import com.parkcollab.backend.dadoBasico.DadoBasico;
import com.parkcollab.backend.domain.estacionamento.Estacionamento;
import com.parkcollab.backend.domain.funcionario.Funcionario;
import com.parkcollab.backend.domain.funcionario.FuncionarioRequest;
import com.parkcollab.backend.domain.login.Login;
import com.parkcollab.backend.repository.FuncionarioRepository;
import com.parkcollab.backend.service.Estacionamento.EstacionamentoService;
import com.parkcollab.backend.service.dadoBasico.DadoBasicoService;
import com.parkcollab.backend.service.login.LoginService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{


    private final FuncionarioRepository funcionarioRepository;
    private final EstacionamentoService estacionamentoService;
    private final DadoBasicoService dadoBasicoService;
    private final LoginService loginService;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository, EstacionamentoService estacionamentoService, DadoBasicoService dadoBasicoService, LoginService loginService) {
        this.funcionarioRepository = funcionarioRepository;
        this.estacionamentoService = estacionamentoService;
        this.dadoBasicoService = dadoBasicoService;
        this.loginService = loginService;
    }

    @Override
    public Funcionario createFuncionario(FuncionarioRequest funcionarioRequest) {

        Estacionamento estacionamento = estacionamentoService.findByCnpj(funcionarioRequest.getCnpjEstacionamento());

        if(estacionamento == null) throw new RuntimeException("ESTACIONAMENTO NÃO ENCONTRADO");

        DadoBasico dadoBasico = dadoBasicoService.save(
                DadoBasico.builder()
                        .nome(funcionarioRequest.getNome())
                        .documento(funcionarioRequest.getCpf())
                        .build()
        );

        Login login = loginService.save(
                Login.builder()
                        .type("USER")
                        .email(funcionarioRequest.getEmail())
                        .password(funcionarioRequest.getSenha())
                        .build()
        );


        return funcionarioRepository.save(
                Funcionario.builder()
                        .estacionamento(estacionamento)
                        .aprovado(false)
                        .dataSaida(null)
                        .dadoBasico(dadoBasico)
                        .login(login)
                        .build()

        );
    }
}
