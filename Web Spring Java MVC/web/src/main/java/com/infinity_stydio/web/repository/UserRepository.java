package com.infinity_stydio.web.repository;

import com.infinity_stydio.web.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
