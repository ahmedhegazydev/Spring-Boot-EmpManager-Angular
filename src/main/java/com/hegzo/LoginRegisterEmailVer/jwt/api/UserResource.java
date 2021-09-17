package com.hegzo.LoginRegisterEmailVer.jwt.api;

import com.hegzo.LoginRegisterEmailVer.jwt.domain.User;
import com.hegzo.LoginRegisterEmailVer.jwt.service.UserService;
import com.hegzo.LoginRegisterEmailVer.jwt.service.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;


    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }



}
