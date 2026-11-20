package com.riderlink.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 * csrf().disable() disables Cross-Site Request Forgery protection.
 * We disable it here to simplify testing the REST API as required by the assignment.
 *
 * Note: For production applications using session-based authentication,
 * CSRF protection should normally remain enabled.
 */
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/auth/signup/rider",
                                "/auth/signup/driver",
                                "/health"
                        ).permitAll()
                        .anyRequest().authenticated()
                )

                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
