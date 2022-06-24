package com.api.filmeteca.controller;

import com.api.filmeteca.dto.FavoritoDto;
import com.api.filmeteca.model.Favorito;

import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.service.FavoritoService;
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
@RequestMapping("/favorito")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> save (@Valid @RequestBody FavoritoDto favoritoDto){

        //GET email do user
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Busca Usuario
        Optional<Usuario> usuarioOptional = usuarioService.findByEmail(email);

        if(!usuarioOptional.isEmpty()){

            Usuario usuario = usuarioOptional.get();

            Favorito favorito = new Favorito();
            BeanUtils.copyProperties(favoritoDto, favorito);

            favorito.setData(new Date());
            favorito.setUsuario(usuarioOptional.get());

            Favorito result = favoritoService.save(favorito,usuario);

            if(result == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(result);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

    }

    @GetMapping
    public ResponseEntity<Object> findByUsuario(){
        //GET email do user
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Busca Usuario
        Optional<Usuario> usuarioOptional = usuarioService.findByEmail(email);

        if(!usuarioOptional.isEmpty()){

            return ResponseEntity.status(HttpStatus.OK).body(favoritoService.findByUsuario(usuarioOptional.get()));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}
