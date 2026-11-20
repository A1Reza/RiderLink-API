package com.riderlink.service;

import com.riderlink.dto.DriverSignupRequest;
import com.riderlink.exception.UsernameAlreadyExistsException;
import com.riderlink.model.Driver;
import com.riderlink.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DriverSignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(DriverSignupRequest request) {

        if (userRepository.existsByUsername(request.username())) {
            throw new UsernameAlreadyExistsException(request.username());
        }

        Driver driver = new Driver();

        driver.setUsername(request.username());
        driver.setPassword(passwordEncoder.encode(request.password()));
        driver.setFullName(request.fullName());
        driver.setPhone(request.phone());
        driver.setVehicleLicenseNumber(request.vehicleLicenseNumber());

        userRepository.save(driver);
    }
}
