package com.api.filmeteca.controller;

import java.util.List;

import com.api.filmeteca.dto.UsuarioDto;
import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.service.UsuariosService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public List<Usuario> findAll() {

        return usuariosService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UsuarioDto usuarioDto) {

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);

        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.save(usuario));

    }

}
