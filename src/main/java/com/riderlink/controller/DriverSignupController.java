package com.riderlink.controller;

import com.riderlink.dto.DriverSignupRequest;
import com.riderlink.exception.UsernameAlreadyExistsException;
import com.riderlink.service.DriverSignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class DriverSignupController {

    private final DriverSignupService driverSignupService;

    @PostMapping("/auth/signup/driver")
    public ResponseEntity<Map<String, String>> signup(
            @Valid @RequestBody DriverSignupRequest req,
            BindingResult validation) {

        if (validation.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Check your signup details"));
        }

        try {
            driverSignupService.signup(req);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("message", "Driver account created"));

        } catch (UsernameAlreadyExistsException ex) {

            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", "Username already exists"));
        }
    }
}
