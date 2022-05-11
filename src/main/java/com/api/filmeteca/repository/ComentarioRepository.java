package com.api.filmeteca.repository;

import java.util.*;

import com.api.filmeteca.model.Comentario;
import com.api.filmeteca.model.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public class ComentarioRepository {

    // ESTATICO PARA TEST
    public List<Comentario> findComentarios(int idFilme) {

        List<Comentario> comentarios = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            Usuario user = new Usuario();
            Comentario comentario = new Comentario();

            comentario.setData(new java.util.Date());
            comentario.setTexto("Filme Ruim Rapaz, era melhor ter ido ver o filme do Pelé");

            user.setNome("user" + i);
            comentario.setUser(user);

            comentarios.add(comentario);
        }

        return comentarios;
    }

}
