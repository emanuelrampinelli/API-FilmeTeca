package com.api.filmeteca.controller;

import com.api.filmeteca.dto.AvaliacaoDto;
import com.api.filmeteca.dto.FilmeDto;
import com.api.filmeteca.dto.UsuarioDto;
import com.api.filmeteca.model.Avaliacao;

import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.service.AvaliacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    
    @PostMapping
    public ResponseEntity<Object> saveAvaliacao (@Valid @RequestBody AvaliacaoDto avaliacaoDto){

        Avaliacao avaliacao = new Avaliacao();
        BeanUtils.copyProperties(avaliacaoDto, avaliacao);
        avaliacao.setDataCadastro(new Date());

        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.saveAvaliacao(avaliacao));
    }

    @GetMapping("/usuario")
    public ResponseEntity<Object> findPorUsuario(@Valid @RequestBody UsuarioDto usuarioDto){

        if(usuarioDto.getId() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);

        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoService.findPorUsuario(usuario));

    }

    @GetMapping("/filme")
    public ResponseEntity<Object> findPorFilme(@Valid @RequestBody FilmeDto filmeDto){

        if(filmeDto.getId() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(avaliacaoService.findPorFilme(filmeDto));
    }

}
