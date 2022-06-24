package com.api.filmeteca.controller;

import com.api.filmeteca.dto.InteresseDto;

import com.api.filmeteca.model.Comentario;
import com.api.filmeteca.model.Interesse;
import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.service.InteresseService;
import com.api.filmeteca.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/interesse")
public class InteresseController {

    @Autowired
    private InteresseService interesseService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody InteresseDto interesseDto){

        //GET email do user
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Busca Usuario
        Optional<Usuario> usuarioOptional = usuarioService.findByEmail(email);

        if(!usuarioOptional.isEmpty()){

            Usuario usuario = usuarioOptional.get();

            Interesse interesse = new Interesse();
            BeanUtils.copyProperties(interesseDto, interesse);

            interesse.setData(new Date());
            interesse.setUsuario(usuarioOptional.get());

            Interesse result = interesseService.save(interesse,usuario);

            if(result == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(result);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @GetMapping
    public ResponseEntity<Object> findByUser(){

        //GET email do user
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Busca Usuario
        Optional<Usuario> usuarioOptional = usuarioService.findByEmail(email);

        if(!usuarioOptional.isEmpty()){

            return ResponseEntity.status(HttpStatus.OK).body(interesseService.findByUsuario(usuarioOptional.get()));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

}
