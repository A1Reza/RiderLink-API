package com.riderlink.dto;

/*
 * We use a separate response DTO instead of returning the entity
 * to prevent exposing sensitive information such as the password
 * and to control which fields are included in API responses.
 */
public record UserResponse(
        Long id,
        String username,
        String fullName,
        String phone
) {
}
