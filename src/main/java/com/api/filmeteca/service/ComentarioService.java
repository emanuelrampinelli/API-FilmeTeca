package com.api.filmeteca.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.api.filmeteca.model.Comentario;
import com.api.filmeteca.model.Usuario;

public class ComentarioService {

    public List<Comentario> carregaComentario() {

        List<Comentario> comentarios = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            Usuario user = new Usuario();
            Comentario comentario = new Comentario();

            comentario.setData(new Date());
            comentario.setTexto("Filme Ruim Rapaz, era melhor ter ido ver o filme do Pelé");

            user.setNome("user" + i);
            comentario.setUser(user);

            comentarios.add(comentario);
        }

        return comentarios;
    }

}
