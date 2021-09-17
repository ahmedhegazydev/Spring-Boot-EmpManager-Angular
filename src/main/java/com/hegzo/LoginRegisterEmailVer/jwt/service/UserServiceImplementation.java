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
        log.info("Saving new user {} into database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} into database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}",  roleName,  username);
        User user = userRepo.findByName(username);
        Role role =  roleRepo.findByName(roleName);
        user.getRoles().add(role);///this needs Tranactional
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {} ", username);
        return userRepo.findByName(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }


}
