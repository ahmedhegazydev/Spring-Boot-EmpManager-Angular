package com.hegzo.LoginRegisterEmailVer.jwt.service;

import com.hegzo.LoginRegisterEmailVer.jwt.domain.Role;
import com.hegzo.LoginRegisterEmailVer.jwt.domain.User;
import com.hegzo.LoginRegisterEmailVer.jwt.repo.RoleRepo;
import com.hegzo.LoginRegisterEmailVer.jwt.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@Slf4j///for Logging
public class UserServiceImplementation implements UserService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;


    @Override
    public User saveUser(User user) {
        log.error("Saving user into database");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByName(username);
        Role role =  roleRepo.findByName(roleName);
        user.getRoles().add(role);///this needs Tranactional
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
