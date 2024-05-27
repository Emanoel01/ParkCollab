package com.parkcollab.backend.dadoBasico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_dado_basico")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadoBasico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String documento;

    private String nome;
}
