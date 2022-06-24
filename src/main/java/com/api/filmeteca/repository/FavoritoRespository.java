package com.api.filmeteca.repository;

import com.api.filmeteca.model.Favorito;
import com.api.filmeteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritoRespository extends JpaRepository<Favorito,Long> {

    public List<Favorito> findByUsuario(Usuario usuario);
    public List<Favorito> findByUsuarioAndIdFilme(Usuario usuario,Long idFilme);
}
