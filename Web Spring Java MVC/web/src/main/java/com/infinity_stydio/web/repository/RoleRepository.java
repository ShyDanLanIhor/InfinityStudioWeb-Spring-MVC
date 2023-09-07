package com.infinity_stydio.web.repository;

import com.infinity_stydio.web.models.Role;
import com.infinity_stydio.web.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
