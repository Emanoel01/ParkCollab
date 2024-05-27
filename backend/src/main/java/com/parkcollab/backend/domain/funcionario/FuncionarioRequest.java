package com.parkcollab.backend.domain.funcionario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuncionarioRequest {

    private String nome;
    private String cpf;
    private String cnpjEstacionamento;
    private String email;
    private String senha;

}
