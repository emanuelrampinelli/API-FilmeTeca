package com.api.filmeteca.repository;

import com.api.filmeteca.dto.ComentarioDto;
import com.api.filmeteca.model.Comentario;

import com.api.filmeteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    public List<Comentario> findByUsuario(Usuario usuario);

}
