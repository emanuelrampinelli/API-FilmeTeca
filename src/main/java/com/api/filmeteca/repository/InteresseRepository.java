package com.api.filmeteca.repository;

import com.api.filmeteca.model.Interesse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresseRepository extends JpaRepository<Interesse,Long> {
}
