package com.api.filmeteca.service;

import java.util.List;
import java.util.Optional;

import com.api.filmeteca.dto.ComentarioDto;
import com.api.filmeteca.dto.FilmeDto;
import com.api.filmeteca.model.Comentario;

import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.repository.ComentarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private FilmeService filmeService;

    public Comentario save(Comentario comentario) {

        return comentarioRepository.save(comentario);
    }

    public List<Comentario> findByUsuario(Usuario usuario) {

        return comentarioRepository.findByUsuario(usuario);
    }

    public List<Comentario> findByFilme(FilmeDto filmeDto){

        return comentarioRepository.findByIdFilme(filmeDto.getId());
    }

    public void delete(Comentario comentario){

        comentarioRepository.delete(comentario);

    }

    public Comentario update(ComentarioDto comentario){

        //Carrega Comentario
        Optional<Comentario> comentarioOptional = comentarioRepository.findById(comentario.getId());

        if(!comentarioOptional.isEmpty()){

            Comentario comentarioLoad = comentarioOptional.get();

            comentarioLoad.setTexto(comentario.getTexto());

            return comentarioRepository.save(comentarioLoad);
        }

        return null;
    }

}
