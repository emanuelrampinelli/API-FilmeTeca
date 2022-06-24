package com.api.filmeteca.controller;

import java.util.Date;
import java.util.Optional;

import com.api.filmeteca.dto.UsuarioDto;
import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.repository.UsuarioRepository;
import com.api.filmeteca.service.UsuarioService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping
    public ResponseEntity<Object> findUsuario() {

        String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Verifica se existe este usuario em banco
        Optional<Usuario> optUsuario = usuarioService.findByEmail(user);

        //Caso nao encontre, return nao autorizado
        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Usuario usuario = optUsuario.get();

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }


    @PostMapping
    public ResponseEntity<Object> createUsuario(@Valid @RequestBody UsuarioDto usuarioDto) {

        Date dataCadastro = new Date();

        //Apenas o nome não esta sendo tratado @Valid do DTO.
        if(usuarioDto.getNome() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        //Criptografa a senha;
        usuarioDto.setSenha(encoder.encode(usuarioDto.getSenha()));

        //Passa as informacoes para Model.
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);
        usuario.setDataCadastro(dataCadastro);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));

    }

}
