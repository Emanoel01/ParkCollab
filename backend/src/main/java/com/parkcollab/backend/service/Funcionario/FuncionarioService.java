package com.parkcollab.backend.service.Funcionario;

import com.parkcollab.backend.domain.funcionario.Funcionario;
import com.parkcollab.backend.domain.funcionario.FuncionarioRequest;

public interface FuncionarioService {

    Funcionario createFuncionario(FuncionarioRequest funcionarioRequest);

}
