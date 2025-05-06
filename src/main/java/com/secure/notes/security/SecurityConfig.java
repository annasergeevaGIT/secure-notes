package com.secure.notes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests.anyRequest().authenticated());
                        //.requestMatchers("/contact").permitAll() // Allow access to /contact without authentication
                        //.requestMatchers("/public/**").permitAll()  // bypass spring security
                        //.requestMatchers("/admin/**").denyAll()

        //http.csrf(AbstractHttpConfigurer::disable);
        //http.formLogin(withDefaults());
        //http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.httpBasic(withDefaults());
        return http.build();
    }
    /*
    @Bean //InMemoryUserDetailsManager
    public UserDetailsService userDetailsService(DataSource dataSource){
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);  // alternatively InMemoryUserDetailsManager

        UserDetails user1 = User.withUsername("user1")  //User class implements UserDetails interface
                .password("{noop}pw1")
                .roles("USER")  // ROLE_ is automatically added
                .build();

        if(!manager.userExists("user1")){
            manager.createUser(
                    user1
            );
        }
        return manager;
    }*/
}
