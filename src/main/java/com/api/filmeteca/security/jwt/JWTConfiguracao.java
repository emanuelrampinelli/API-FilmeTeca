package com.api.filmeteca.security.jwt;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.api.filmeteca.security.jwt.service.DetalheUsuarioServiceImp;


@EnableWebSecurity
public class JWTConfiguracao extends WebSecurityConfigurerAdapter {

    private final DetalheUsuarioServiceImp usuarioServiceImp;
    private final PasswordEncoder passwordEnconder;

    public JWTConfiguracao(DetalheUsuarioServiceImp usuarioServiceImp,
            PasswordEncoder passwordEnconder) {
        this.usuarioServiceImp = usuarioServiceImp;
        this.passwordEnconder = passwordEnconder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioServiceImp).passwordEncoder(passwordEnconder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/genero").permitAll()
                .antMatchers(HttpMethod.GET, "/comentario").permitAll()
                .antMatchers(HttpMethod.GET, "/filme/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/filme/search/{texto}").permitAll()
                .antMatchers(HttpMethod.GET, "/filme/populares/{index}").permitAll().anyRequest()
                .authenticated().and().addFilter(new JWTAutenticarFilter(authenticationManager()))
                .addFilter(new JWTValidarFilter(authenticationManager())).sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors().and().csrf().disable();

        // ORDEM
        // Permiti todos post do /login
        // Todas as outras devem esta auth
        // e
        // add Filter
        // add Filter
        // Ambinte STATELESS para não salvar o estado do usuario.

    }

}
