package com.hegzo.LoginRegisterEmailVer.jwt.repo;

import com.hegzo.LoginRegisterEmailVer.jwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByName(String username);

}
