package com.hegzo.LoginRegisterEmailVer.jwt.repo;

import com.hegzo.LoginRegisterEmailVer.jwt.domain.Role;
import com.hegzo.LoginRegisterEmailVer.jwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
