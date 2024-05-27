package com.parkcollab.backend.service.login;

import com.parkcollab.backend.controller.EstacionamentoController;
import com.parkcollab.backend.domain.login.Login;
import com.parkcollab.backend.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    private final LoginRepository loginRepository;

    private static Logger logger = LoggerFactory.getLogger(EstacionamentoController.class);


    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login save(Login login) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(login.getPassword());
        login.setPassword(encodedPassword);
        return loginRepository.save(login);
    }

    @Override
    public Login findByEmail(String email) {
        Login login= loginRepository.findByEmail(email);
        if(login == null) logger.error("USUARIO NAO ENCONTRADO");

        return login;
    }
}
