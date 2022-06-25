package com.api.filmeteca.controller;

import java.util.Date;
import java.util.Optional;

import com.api.filmeteca.dto.ComentarioDto;
import com.api.filmeteca.dto.FilmeDto;

import com.api.filmeteca.model.Comentario;
import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.service.ComentarioService;

import com.api.filmeteca.service.FilmeService;
import com.api.filmeteca.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public ResponseEntity<Object> findByUsuario(){

        //GET email do user
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Busca Usuario
        Optional<Usuario> usuarioOptional = usuarioService.findByEmail(email);

        if(!usuarioOptional.isEmpty()){

            Usuario usuario = new Usuario();
            BeanUtils.copyProperties(usuarioOptional.get(), usuario);

            return ResponseEntity.status(HttpStatus.OK).body(comentarioService.findByUsuario(usuario));

        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

    @GetMapping("/filme/{id}")
    public ResponseEntity<Object> findByFilme(@PathVariable(value = "id") Long id){

        FilmeDto filmeDto = new FilmeDto();

        try{
            filmeDto.setId(id);
        }catch (NumberFormatException ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(comentarioService.findByFilme(filmeDto));

    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ComentarioDto comentarioDto) {

        //GET email do user
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Busca Usuario
        Optional<Usuario> usuarioOptional = usuarioService.findByEmail(email);

        if(!usuarioOptional.isEmpty()){

            Comentario comentario = new Comentario();
            BeanUtils.copyProperties(comentarioDto, comentario);
            comentario.setDataCadastro(new Date());
            comentario.setUsuario(usuarioOptional.get());

            return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.save(comentario));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody ComentarioDto comentarioDto){

        Comentario result = comentarioService.update(comentarioDto);

        if(result == null){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody ComentarioDto comentarioDto){

        Comentario comentario = new Comentario();
        BeanUtils.copyProperties(comentarioDto, comentario);

        comentarioService.delete(comentario);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
