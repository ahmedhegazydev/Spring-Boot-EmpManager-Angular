package com.hegzo.LoginRegisterEmailVer.registeration.controller;


import com.hegzo.LoginRegisterEmailVer.registeration.data.RegistrationRequest;
import com.hegzo.LoginRegisterEmailVer.registeration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {


    private final RegistrationService registrationService;


    @PostMapping
    public String register(@RequestBody RegistrationRequest registrationRequest) {
//    public void register(@RequestBody RegistrationRequest registrationRequest) {
        return registrationService.register(registrationRequest);
//        return "it Works";
    }

    @GetMapping(path = "confirm")
    public String confirmToken(@RequestParam String token) {
        return registrationService.confirmToken(token);
    }



}
