package com.abulibde.perfectbathroom.config;

import com.abulibde.perfectbathroom.repository.UserRepository;
import com.abulibde.perfectbathroom.service.impl.PerfectBathroomUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private final String rememberMeKey;

    public SecurityConfiguration(@Value("${perfect-bathroom.remember.me.key}") String rememberMeKey){
        this.rememberMeKey = rememberMeKey;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//Configuration goes here
        httpSecurity.authorizeHttpRequests(
                // Define which urls are visible by which users
                authorizeRequests -> authorizeRequests
                        //All static resources which are situated in js, images, css are available for anyone
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        //Allow anyone to visit home, registration and login page
                        .requestMatchers("/", "/users/login", "users/register", "/users/login-error").permitAll()
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
                            .logoutUrl("/users/logout")
                            //Redirect here with successful logout
                            .logoutSuccessUrl("/")
                            //Invalidate the HTTP session
                            .invalidateHttpSession(true);
                }
        ).rememberMe(
                rememberMe ->{
                    rememberMe
                            .key(rememberMeKey)
                            .rememberMeParameter("rememberme")
                            .rememberMeCookieName("rememberme");
                }

        );

      return   httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        //This service translates the PerfectBathroom users and roles to
        //representation which spring security understands
        return new PerfectBathroomUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}
