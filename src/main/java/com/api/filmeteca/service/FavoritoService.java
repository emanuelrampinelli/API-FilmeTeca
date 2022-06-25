package com.api.filmeteca.service;

import com.api.filmeteca.model.Favorito;

import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.repository.FavoritoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {

    @Autowired
    private FavoritoRespository favoritoRespository;

    public Favorito save(Favorito favorito, Usuario usuario){

        //Verifica se o filme ja foi add aos interesses do usuario;
        List<Favorito> favoritos = favoritoRespository.findByUsuarioAndIdFilme(usuario,favorito.getIdFilme());

        if(favoritos.isEmpty()){
            return favoritoRespository.save(favorito);
        }

        return null;
    }

    public List<Favorito> findByUsuario(Usuario usuario){

        return favoritoRespository.findByUsuario(usuario);
    }

    public void delete(Favorito favorito){

        favoritoRespository.delete(favorito);

    }


}
