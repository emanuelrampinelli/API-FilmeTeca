package com.api.filmeteca.controller;

import java.util.List;
import java.util.Optional;

import com.api.filmeteca.dto.UsuarioDto;
import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.repository.UsuarioRepository;
import com.api.filmeteca.service.UsuariosService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping
    public List<Usuario> findAll() {

        return usuariosService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UsuarioDto usuarioDto) {

        usuarioDto.setSenha(encoder.encode(usuarioDto.getSenha()));
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);

        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.save(usuario));

    }

    @PostMapping("/login2")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login, @RequestParam String senha) {

        Optional<Usuario> optUsuario = usuarioRepository.findByEmail(login);

        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Usuario usuario = optUsuario.get();
        boolean isValid = encoder.matches(senha, usuario.getSenha());

        HttpStatus status = isValid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(isValid);

    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> validarSenha2(@RequestBody UsuarioDto usuarioDto) {

        Optional<Usuario> optUsuario = usuarioRepository.findByEmail(usuarioDto.getEmail());

        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Usuario usuario = optUsuario.get();
        boolean isValid = encoder.matches(usuarioDto.getSenha(), usuario.getSenha());

        HttpStatus status = isValid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(isValid);

    }
}
