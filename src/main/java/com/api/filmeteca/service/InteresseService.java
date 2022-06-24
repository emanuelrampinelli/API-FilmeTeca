package com.api.filmeteca.service;

import com.api.filmeteca.model.Interesse;
import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.repository.InteresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteresseService {

    @Autowired
    private InteresseRepository interesseRepository;

    public Interesse save (Interesse interesse, Usuario usuario){

        //Verifica se o filme ja foi add aos interesses do usuario;
        List<Interesse> interesseList = interesseRepository.findByUsuarioAndIdFilme(usuario,interesse.getIdFilme());

        if(interesseList.isEmpty()){
            return interesseRepository.save(interesse);
        }

        return null;
    }

    public List<Interesse> findByUsuario(Usuario usuario){

        return interesseRepository.findByUsuario(usuario);
    }
}
