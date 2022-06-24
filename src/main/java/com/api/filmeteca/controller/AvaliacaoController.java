package com.api.filmeteca.controller;

import com.api.filmeteca.dto.AvaliacaoDto;
import com.api.filmeteca.dto.FilmeDto;
import com.api.filmeteca.model.Avaliacao;

import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.service.AvaliacaoService;
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
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody AvaliacaoDto avaliacaoDto){

        //GET email do user
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Busca Usuario
        Optional<Usuario> usuarioOptional = usuarioService.findByEmail(email);

        if(!usuarioOptional.isEmpty()){

            Usuario usuario = usuarioOptional.get();

            Avaliacao avaliacao = new Avaliacao();
            BeanUtils.copyProperties(avaliacaoDto, avaliacao);

            avaliacao.setDataCadastro(new Date());
            avaliacao.setUsuario(usuarioOptional.get());

            Avaliacao result = avaliacaoService.save(avaliacao,usuario);

            if(result == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(result);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

    }

    @GetMapping("/usuario")
    public ResponseEntity<Object> findByUsuario(){

        //GET email do user
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Busca Usuario
        Optional<Usuario> usuarioOptional = usuarioService.findByEmail(email);

        if(!usuarioOptional.isEmpty()){

            return ResponseEntity.status(HttpStatus.OK).body(avaliacaoService.findByUsuario(usuarioOptional.get()));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

    @GetMapping("/filme/{id}")
    public ResponseEntity<Object> findByFilme(@PathVariable(value = "id") Long id){

        FilmeDto filmeDto = new FilmeDto();
        filmeDto.setId(id);

        if(filmeDto.getId() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoService.findByFilme(filmeDto));
    }

    @PutMapping
    public ResponseEntity<Object> update (@Valid @RequestBody AvaliacaoDto avaliacaoDto){

        Avaliacao avaliacao = new Avaliacao();
        BeanUtils.copyProperties(avaliacaoDto, avaliacao);

        Avaliacao result = avaliacaoService.update(avaliacao);

        if(result == null){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody AvaliacaoDto avaliacaoDto){

        Avaliacao avaliacao = new Avaliacao();
        BeanUtils.copyProperties(avaliacaoDto, avaliacao);

        avaliacaoService.delete(avaliacao);

        return ResponseEntity.status(HttpStatus.OK).body(null);

    }
}
