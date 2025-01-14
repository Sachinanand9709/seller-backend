/*package com.example.test.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Elements.CSRF;

@Configuration
public class Security {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http.csrf(csrfConfigurer-> csrfConfigurer.disable() )// Disable CSRF for simplicity in this case

       .authorizeHttpRequests(auth ->auth
                .requestMatchers("/auth/signup", "/auth/login").permitAll() // Allow public access
                .anyRequest().authenticated()
       )// Require authentication for other endpoints

                .httpBasic(Customizer.withDefaults()); // Basic authentication (you can configure other mechanisms if needed)

        return http.build();
    }


}
package com.example.test.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.config.Customizer;

@Configuration
public class Security{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrfConfigurer -> csrfConfigurer.disable()) // Disable CSRF for simplicity in this case
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/auth/signup", "/api/auth/login").permitAll() // Allow signup/login without authentication
                                .anyRequest().authenticated() // All other requests require authentication
                )
                .httpBasic(Customizer.withDefaults()); // Basic authentication (you can configure other mechanisms if needed)

        return http.build();
    }
}*/

package com.example.test.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable CSRF for simplicity (may not be ideal for production, but good for now)
        http.csrf(csrfConfigurer -> csrfConfigurer.disable())
      //  http.csrf().disable()
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/auth/signup", "/api/auth/login").permitAll()

                        // Allow signup/login without authentication
                        .requestMatchers("/api/sellers/**").permitAll()
                        .anyRequest().authenticated() // Require authentication for other endpoints
                );

        return http.build();
    }
}


