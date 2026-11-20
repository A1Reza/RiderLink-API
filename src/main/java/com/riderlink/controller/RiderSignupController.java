package com.riderlink.controller;

import com.riderlink.dto.RiderSignupRequest;
import com.riderlink.exception.UsernameAlreadyExistsException;
import com.riderlink.service.RiderSignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
 * BindingResult stores validation errors produced by @Valid.
 * It must immediately follow the validated parameter so we can handle
 * validation errors ourselves and return a meaningful HTTP response.
 */
@RestController
@RequiredArgsConstructor
public class RiderSignupController {

    private final RiderSignupService riderSignupService;

    @PostMapping("/auth/signup/rider")
    public ResponseEntity<Map<String, String>> signup(
            @Valid @RequestBody RiderSignupRequest req,
            BindingResult validation) {

        if (validation.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Check your signup details"));
        }

        try {
            riderSignupService.signup(req);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("message", "Rider account created"));

        } catch (UsernameAlreadyExistsException ex) {

            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", "Username already exists"));
        }
    }
}
