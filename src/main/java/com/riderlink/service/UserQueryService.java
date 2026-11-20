package com.riderlink.service;

import com.riderlink.dto.UserResponse;
import com.riderlink.model.UserDao;
import com.riderlink.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserRepository userRepository;

    public List<UserResponse> findAll() {

        return userRepository.findAll()
                .stream()
                .map(this::toUserResponse)
                .toList();
    }

    public UserResponse findByUsername(String username) {

        return userRepository.findByUsername(username)
                .map(this::toUserResponse)
                .orElse(null);
    }

    private UserResponse toUserResponse(UserDao user) {

        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getFullName(),
                user.getPhone()
        );
    }
}
