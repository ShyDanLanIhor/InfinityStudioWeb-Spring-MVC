package com.infinity_stydio.web.service;

import com.infinity_stydio.web.dto.RegistrationDto;
import com.infinity_stydio.web.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
