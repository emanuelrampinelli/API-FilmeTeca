package com.api.filmeteca.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("")
public class MainController {

    @GetMapping(value = "/")
    public String mainController() {

        return "IH-LIGOU";
    }
}
