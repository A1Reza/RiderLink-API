package com.riderlink.service;

import com.riderlink.model.UserDao;
import com.riderlink.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DatabaseUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserDao user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found: " + username
                        )
                );

        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
/*
In this step, we will implement the connection between Spring Security and PostgreSQL.
The goal is for Spring Security to retrieve user information from the database when a user logs in,
 rather than using the default user defined in `application.properties`.

What is `UserDetailsService`?
It is an interface in Spring Security responsible for loading user information for authentication purposes.

What is `loadUserByUsername()`?
Spring Security invokes this method during the login process to locate the specific user.

What is `UsernameNotFoundException`?
This exception is thrown if the username does not exist in the database.

What is `User.withUsername()`?
It prepares user information in the `UserDetails` format required by Spring Security.

What is `roles("USER")`?
It assigns the "USER" role to the user. Currently, both "Rider" and "Driver" types share the same role.

Default User vs. Database Authentication
We have included the following explanation as a comment at the top of the class:
- Default User: A default user that Spring Boot can create using the `spring.security.user.name` and `spring.security.user.password` configuration properties.
- Database Authentication: User information is retrieved from the database, allowing for the registration and login of various users.

The Login Flow in Our Project

User Login
Username + Password
        ↓
Spring Security
        ↓
DatabaseUserDetailsService
loadUserByUsername()
        ↓
UserRepository
findByUsername()
        ↓
PostgreSQL
APP_USER

Important Note: We do not perform password comparison within this class. Spring Security handles this using `PasswordEncoder.matches()`.
*/