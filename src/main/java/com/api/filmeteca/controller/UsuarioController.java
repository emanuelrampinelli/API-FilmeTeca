package com.api.filmeteca.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UsuarioController {

    @PostMapping
    public void usuarioTeste(@RequestParam String usuario) {
        System.out.println(usuario);
    }

}
