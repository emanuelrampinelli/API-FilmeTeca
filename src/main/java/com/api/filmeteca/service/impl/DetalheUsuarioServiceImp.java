package com.api.filmeteca.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.api.filmeteca.data.DetalheUsuarioData;
import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.repository.UsuarioRepository;

@Component
public class DetalheUsuarioServiceImp implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);

        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Email não cadastrado: " + username);
        }

        return new DetalheUsuarioData(usuario);
    }

}
