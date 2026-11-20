package com.riderlink.controller;

import com.riderlink.dto.UserResponse;
import com.riderlink.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserDirectoryController {

    private final UserQueryService userQueryService;

    @GetMapping
    public List<UserResponse> findAll() {
        return userQueryService.findAll();
    }
}
