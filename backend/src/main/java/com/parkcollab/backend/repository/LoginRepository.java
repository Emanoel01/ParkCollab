package com.parkcollab.backend.repository;

import com.parkcollab.backend.domain.login.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

    Login findByEmail(String email);

}
