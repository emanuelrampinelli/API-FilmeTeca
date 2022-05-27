package com.api.filmeteca.service;

import java.util.ArrayList;
import java.util.List;

import com.api.filmeteca.model.Comentario;
import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.repository.IComentarioRepository;

import org.joda.time.DateTime;

public class ComentarioService {

    final IComentarioRepository comentarioRepository;

    public ComentarioService(IComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public List<Comentario> carregaComentario(int idFilme) {

        return this.findComentarios(idFilme);
    }

    // ESTATICO PARA TEST
    public List<Comentario> findComentarios(int idFilme) {

        List<Comentario> comentarios = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            Usuario user = new Usuario();
            Comentario comentario = new Comentario();

            comentario.setData(DateTime.now());
            comentario.setTexto("Filme Ruim Rapaz, era melhor ter ido ver o filme do Pelé");

            user.setNome("user" + i);
            comentario.setUser(user);

            comentarios.add(comentario);
        }

        return comentarios;
    }

}
