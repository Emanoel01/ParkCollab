package com.parkcollab.backend.repository;

import com.parkcollab.backend.domain.estacionamento.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Integer> {

    Estacionamento findByCnpj(String documento);

}
