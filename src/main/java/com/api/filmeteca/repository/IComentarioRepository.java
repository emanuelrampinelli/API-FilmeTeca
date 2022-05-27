package com.api.filmeteca.repository;

import java.util.*;

import com.api.filmeteca.model.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, UUID> {

}
