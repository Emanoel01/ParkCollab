package com.parkcollab.backend.service.Estacionamento;

import com.parkcollab.backend.domain.estacionamento.Estacionamento;
import com.parkcollab.backend.domain.estacionamento.EstacionamentoRequest;

public interface EstacionamentoService {

    Estacionamento findByCnpj(String document);

    Estacionamento create(EstacionamentoRequest estacionamentoRequest);

}
