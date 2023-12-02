package com.abulibde.perfectbathroom.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//Configuration goes here
        httpSecurity.authorizeHttpRequests(
                // Define which urls are visible by which users
                authorizeRequests -> authorizeRequests
                        //All static resources which are situated in js, images, css are available for anyone
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        //Allow anyone to visit home, registration and login page
                        .requestMatchers("/", "/users/login", "users/register").permitAll()
                        //all other requests are authenticated
                        .anyRequest().authenticated()

        ).formLogin(
                formLogin ->
                        formLogin
                                //Redirect here when we try to access something that are not allowed
                                //Also this is the page where we perform login
                                .loginPage("/users/login")
                                //The names of the input fields (login.html)
                                .usernameParameter("username")
                                .passwordParameter("password")
                                //Redirect here in case of successful login
                                .defaultSuccessUrl("/")
                                //Redirect here in case of fail
                                .failureForwardUrl("/users/login-error")
        ).logout(
                logout ->{
                    logout
                            //The url where we should POST sth in order to perform logout
                            .logoutUrl("users/logout")
                            //Redirect here with successful logout
                            .logoutSuccessUrl("/")
                            //Invalidate the HTTP session
                            .invalidateHttpSession(true);
                }
        );
        // TODO: remember me!

      return   httpSecurity.build();
    }

    @Bean
}