package com.parkcollab.backend.domain.estacionamento;

import com.parkcollab.backend.dadoBasico.DadoBasico;
import com.parkcollab.backend.domain.login.Login;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_estacionamento")
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String cnpj;

    private String nome;

    private String cep;

    private String logradouro;

    private String bairro;

    private String cidade;

    private String uf;

    private String numero;

    @JoinColumn(name = "id_dado_basico", referencedColumnName = "id")
    @OneToOne
    private DadoBasico dadoBasico;

    @JoinColumn(name = "id_login", referencedColumnName = "id")
    @OneToOne
    private Login login;

    private Integer qntdVagas;
}
