package com.api.filmeteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participante")
public class PaticipanteController {

    @GetMapping("/teste")
    public String procurarParticipante() {

        return "A";
    }

}
