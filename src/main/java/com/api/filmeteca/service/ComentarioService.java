package com.api.filmeteca.service;

import java.util.List;

import com.api.filmeteca.model.Comentario;

import com.api.filmeteca.repository.ComentarioRepository;

public class ComentarioService {

    private ComentarioRepository comentarioRepository;

    public ComentarioService() {
        this.comentarioRepository = new ComentarioRepository();
    }

    public List<Comentario> carregaComentario(int idFilme) {

        return comentarioRepository.findComentarios(idFilme);
    }

}
