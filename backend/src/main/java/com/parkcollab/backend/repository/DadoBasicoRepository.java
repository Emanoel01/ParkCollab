package com.parkcollab.backend.repository;

import com.parkcollab.backend.dadoBasico.DadoBasico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadoBasicoRepository extends JpaRepository<DadoBasico, Integer> {
}
