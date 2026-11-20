package com.riderlink.service;

import com.riderlink.dto.RiderSignupRequest;
import com.riderlink.exception.UsernameAlreadyExistsException;
import com.riderlink.model.Rider;
import com.riderlink.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor  //@RequiredArgsConstructor: Generates a constructor for `final` fields and performs constructor injection.
public class RiderSignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(RiderSignupRequest request) {

        if (userRepository.existsByUsername(request.username())) {
            throw new UsernameAlreadyExistsException(request.username());
        }

        Rider rider = new Rider();

        rider.setUsername(request.username());
        rider.setPassword(passwordEncoder.encode(request.password()));
        rider.setFullName(request.fullName());
        rider.setPhone(request.phone());
        rider.setHomeAddress(request.homeAddress());

        userRepository.save(rider);
    }
}
