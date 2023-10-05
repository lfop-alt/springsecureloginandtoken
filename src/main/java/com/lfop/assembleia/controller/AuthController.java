package com.lfop.assembleia.controller;

import com.lfop.assembleia.dto.Login;
import com.lfop.assembleia.model.UserModel;
import com.lfop.assembleia.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.login(), login.password());
        Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var user = (UserModel) authentication.getPrincipal();

        return tokenService.gerarToken(user);
    }
}
