package com.api.filmeteca.controller;

import java.util.Date;
import java.util.Optional;

import com.api.filmeteca.dto.UsuarioDto;
import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.service.*;

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
    private FavoritoService favoritoService;

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private InteresseService interesseService;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping
    public ResponseEntity<Object> findByUsuario() {

        String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Verifica se existe este usuario em banco
        Optional<Usuario> optUsuario = usuarioService.findByEmail(user);

        //Caso nao encontre, return nao autorizado
        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Usuario usuario = optUsuario.get();
        UsuarioDto usuarioDto = new UsuarioDto();

        //Passa as informacoes para Model.
        BeanUtils.copyProperties(optUsuario.get(), usuarioDto);

        usuarioDto.setAvaliacaos(avaliacaoService.findByUsuario(usuario));
        usuarioDto.setComentarios(comentarioService.findByUsuario(usuario));
        usuarioDto.setInteresses(interesseService.findByUsuario(usuario));
        usuarioDto.setFavoritos(favoritoService.findByUsuario(usuario));

        return ResponseEntity.status(HttpStatus.OK).body(usuarioDto);
    }


    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody UsuarioDto usuarioDto) {

        //Apenas o nome não esta sendo tratado @Valid do DTO.
        if(usuarioDto.getNome() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        //Criptografa a senha;
        usuarioDto.setSenha(encoder.encode(usuarioDto.getSenha()));

        //Passa as informacoes para Model.
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);
        usuario.setDataCadastro(new Date());

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));

    }

}
