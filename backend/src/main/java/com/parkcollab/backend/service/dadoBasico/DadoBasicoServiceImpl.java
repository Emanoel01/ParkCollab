package com.parkcollab.backend.service.dadoBasico;

import com.parkcollab.backend.dadoBasico.DadoBasico;
import com.parkcollab.backend.repository.DadoBasicoRepository;
import org.springframework.stereotype.Service;

@Service
public class DadoBasicoServiceImpl implements DadoBasicoService{

    private final DadoBasicoRepository dadoBasicoRepository;

    public DadoBasicoServiceImpl(DadoBasicoRepository dadoBasicoRepository) {
        this.dadoBasicoRepository = dadoBasicoRepository;
    }


    @Override
    public DadoBasico save(DadoBasico dadoBasico) {
        return dadoBasicoRepository.save(dadoBasico);
    }
}
