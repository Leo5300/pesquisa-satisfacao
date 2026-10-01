package br.com.aweb.pesquisa_satisfacao.security;

import java.beans.BeanProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration 
@EnableWebSecurity 
public class ConfiguracoesDeSeguranca { 

    @Bean
    public InMemoryUserDetailsManager dadosUsuarios(){
        UserDetails usuario1 = User.builder()
         .username("leo@email.com")
         .password("{noop}andre123")
         .build();

          UserDetails usuario2 = User.builder()
         .username("leonardo@email.com")
         .password("{noop}leonardo123")
         .build();

         UserDetails usuario3 = User.builder()
         .username("leonardo1@email.com")
         .password("{noop}leonardo1234")
         .build();
        
         return new InMemoryUserDetailsManager(usuario1, usuario2);
    }
    
}
