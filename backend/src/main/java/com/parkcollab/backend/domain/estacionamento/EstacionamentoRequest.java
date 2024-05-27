package com.parkcollab.backend.domain.estacionamento;

import jakarta.annotation.sql.DataSourceDefinition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstacionamentoRequest {

    private String cnpj;
    private String nome;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String numero;
    private String cpfDono;
    private String nomeDono;
    private String email;
    private Integer qntdVagas;
    private String senha;

}
