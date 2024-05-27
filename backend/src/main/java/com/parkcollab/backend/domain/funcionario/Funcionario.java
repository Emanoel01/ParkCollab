package com.parkcollab.backend.domain.funcionario;

import com.parkcollab.backend.dadoBasico.DadoBasico;
import com.parkcollab.backend.domain.estacionamento.Estacionamento;
import com.parkcollab.backend.domain.login.Login;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "tb_funcionario")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Funcionario {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "id_dado_basico", referencedColumnName = "id")
    @OneToOne
    private DadoBasico dadoBasico;

    @JoinColumn(name = "id_login", referencedColumnName = "id")
    @OneToOne
    private Login login;

    @JoinColumn(name = "id_estacionamento", referencedColumnName = "id")
    @ManyToOne
    private Estacionamento estacionamento;

    @Column
    private Boolean aprovado;

    @Column(name = "data_saida")
    private Date dataSaida;

}
