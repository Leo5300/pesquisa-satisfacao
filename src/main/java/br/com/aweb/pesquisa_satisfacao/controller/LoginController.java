package br.com.aweb.pesquisa_satisfacao.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Bean
    public SecurityFilterChain filtroSeguranca(HttpSecurity http) throws Exception{
        return http
        .authorizeHttpRequests(req ->{
            req.requestMatchers("/css/**", "/img/**", "/js/**").permitAll();
            req.anyRequest().authenticated();
        })
        .formLogin(form -> form.loginPage("/login")
            .defaultSuccessUrl("/")
            .permitAll())
        .logout(logout -> logout
            .logoutSuccessUrl("/login?logout")
            .permitAll()
        )

        .build();
    }

}
