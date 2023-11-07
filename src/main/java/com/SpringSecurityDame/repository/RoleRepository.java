package com.SpringSecurityDame.repository;

import com.SpringSecurityDame.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);

}

