package com.lfop.assembleia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    @GetMapping("/teste")
    public String getTest() {
        return "Bom dia, deu certo o bloqueio";
    }

    @GetMapping("/home")
    public String getHome() {
        return "Home";
    }
}
