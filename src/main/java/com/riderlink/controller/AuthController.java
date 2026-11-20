
package com.riderlink.controller;

import com.riderlink.dto.UserResponse;
import com.riderlink.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
/*
 * Authentication means verifying who a person is, like checking
 * someone's identity at the entrance of a building.
 * Authorization means deciding what that person is allowed to access,
 * like a gatekeeper checking which rooms they can enter.
 */
public class AuthController {

    private final UserQueryService userQueryService;

    @GetMapping("/me")
    public UserResponse me(Authentication authentication) {

        return userQueryService.findByUsername(
                authentication.getName()
        );
    }
}
/*
Explanation of Authentication:

The parameter:
Authentication authentication

is provided to the Controller by Spring Security.

And the command:
authentication.getName()

returns the username of the user who has logged in.

Therefore, /auth/me always retrieves the information of the logged-in user.
*/