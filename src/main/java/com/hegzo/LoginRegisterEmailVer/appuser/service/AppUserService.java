package com.hegzo.LoginRegisterEmailVer.appuser.service;

import com.hegzo.LoginRegisterEmailVer.appuser.AppUser;
import com.hegzo.LoginRegisterEmailVer.appuser.repo.AppUserRepository;
import com.hegzo.LoginRegisterEmailVer.registeration.token.ConfirmationToken;
import com.hegzo.LoginRegisterEmailVer.registeration.token.ConfirmationTokenRepository;
import com.hegzo.LoginRegisterEmailVer.registeration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final static String USER_NOT_FOUND = "User with email %s not found";
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

//    public AppUserService(AppUserRepository appUserRepository) {
//        this.appUserRepository = appUserRepository;
//    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }


    public String signUpUser(AppUser appUser){
//    public void signUpUser(AppUser appUser){
        boolean isExist = appUserRepository.findByEmail(appUser.getEmail())
                .isPresent();
        if (isExist){
            throw new IllegalStateException("Email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);


        // TODO: 16/09/2021 AD Send Configuration token
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken =
                new ConfirmationToken(
                        token,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(15),
                        appUser
                );
        confirmationTokenService.saveConfirmationToken(confirmationToken);


        // TODO: 16/09/2021 AD SEND EMAIL



//        return "It Works";
        return token;
    }


    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }


}
