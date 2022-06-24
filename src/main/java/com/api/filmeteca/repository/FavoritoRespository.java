package com.api.filmeteca.repository;

import com.api.filmeteca.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritoRespository extends JpaRepository<Favorito,Long> {
}
