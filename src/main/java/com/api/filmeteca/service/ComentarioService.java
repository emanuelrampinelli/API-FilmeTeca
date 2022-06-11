package com.api.filmeteca.service;

import java.util.List;

import com.api.filmeteca.dto.ComentarioDto;
import com.api.filmeteca.model.Comentario;
import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.repository.ComentarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario saveComentario(Comentario comentario) {

        return comentarioRepository.save(comentario);
    }

    public List<Comentario> findComentario(Usuario usuario) {

        return comentarioRepository.findByUsuario(usuario);
    }

}
