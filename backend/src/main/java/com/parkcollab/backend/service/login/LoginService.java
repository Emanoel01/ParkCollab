package com.parkcollab.backend.service.login;

import com.parkcollab.backend.domain.login.Login;

public interface LoginService {

    Login save(Login login);

    Login findByEmail(String email);

}
