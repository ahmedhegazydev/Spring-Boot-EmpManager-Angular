package com.hegzo.LoginRegisterEmailVer.jwt.service;

import com.hegzo.LoginRegisterEmailVer.jwt.domain.Role;
import com.hegzo.LoginRegisterEmailVer.jwt.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();



}
