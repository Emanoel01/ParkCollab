package com.parkcollab.backend.service.Estacionamento;

import com.parkcollab.backend.dadoBasico.DadoBasico;
import com.parkcollab.backend.domain.estacionamento.Estacionamento;
import com.parkcollab.backend.domain.estacionamento.EstacionamentoRequest;
import com.parkcollab.backend.domain.login.Login;
import com.parkcollab.backend.repository.EstacionamentoRepository;
import com.parkcollab.backend.service.dadoBasico.DadoBasicoService;
import com.parkcollab.backend.service.login.LoginService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EstacionamentoServiceImpl implements EstacionamentoService{

    private final EstacionamentoRepository estacionamentoRepository;
    private final DadoBasicoService dadoBasicoService;
    private final LoginService loginService;

    public EstacionamentoServiceImpl(EstacionamentoRepository estacionamentoRepository, DadoBasicoService dadoBasicoService, LoginService loginService) {
        this.estacionamentoRepository = estacionamentoRepository;
        this.dadoBasicoService = dadoBasicoService;
        this.loginService = loginService;
    }

    @Override
    public Estacionamento findByCnpj(String documento) {
        return estacionamentoRepository.findByCnpj(documento);
    }

    @Override
    @Transactional(rollbackOn = {Exception.class})
    public Estacionamento create(EstacionamentoRequest estacionamentoRequest) {

        Login login = loginService.save(
                Login.builder()
                        .email(estacionamentoRequest.getEmail())
                        .password(estacionamentoRequest.getSenha())
                        .type("ADMIN")
                        .build());
        DadoBasico dadoBasico = dadoBasicoService.save(
                DadoBasico.builder()
                        .documento(estacionamentoRequest.getCpfDono())
                        .nome(estacionamentoRequest.getNomeDono())
                        .build());

        return estacionamentoRepository.save(
                Estacionamento.builder()
                        .cnpj(estacionamentoRequest.getCnpj())
                        .nome(estacionamentoRequest.getNome())
                        .cep(estacionamentoRequest.getCep())
                        .logradouro(estacionamentoRequest.getLogradouro())
                        .bairro(estacionamentoRequest.getBairro())
                        .cidade(estacionamentoRequest.getCidade())
                        .uf(estacionamentoRequest.getUf())
                        .numero(estacionamentoRequest.getNumero())
                        .qntdVagas(estacionamentoRequest.getQntdVagas())
                        .dadoBasico(dadoBasico)
                        .login(login)
                        .build()
        );
    }
}
