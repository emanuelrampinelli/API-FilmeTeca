package com.api.filmeteca.service;

import com.api.filmeteca.model.Comentario;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioService {

    @Transactional
    public Comentario save(Comentario comentario) {

        return new Comentario();
    }

}
