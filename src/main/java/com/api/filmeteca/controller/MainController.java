package com.api.filmeteca.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("")
public class MainController {

    @GetMapping(value = "/")
    public String mainController() {

        String text = "" +
                "<h2>" +
                "GET - <DOMAIN>/filme/populares/{index} <br>" +
                "GET - <DOMAIN>/filme/{id} <br>" +
                "GET - <DOMAIN>/filme/search/{texto} <br><br><h2>" +
                "GET - <DOMAIN>/genero<br>" +
                "<h1>";

        return text;
    }
}
