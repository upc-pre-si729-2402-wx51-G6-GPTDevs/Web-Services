package com.tasklinker.tasklinker.iam.interfaces.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.tasklinker.tasklinker.iam.domain.services.UserCommandService;
import com.tasklinker.tasklinker.iam.interfaces.rest.resources.AuthenticatedUserResource;
import com.tasklinker.tasklinker.iam.interfaces.rest.resources.SignInResource;
import com.tasklinker.tasklinker.iam.interfaces.rest.resources.SignUpResource;
import com.tasklinker.tasklinker.iam.interfaces.rest.resources.UserResource;
import com.tasklinker.tasklinker.iam.interfaces.rest.transform.AuthenticatedUserResourceFromEntityAssembler;
import com.tasklinker.tasklinker.iam.interfaces.rest.transform.SignInCommandFromResourceAssembler;
import com.tasklinker.tasklinker.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import com.tasklinker.tasklinker.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * AuthenticationController
 * <p>
 * This controller is responsible for handling authentication requests.
 * It exposes two endpoints:
 * <ul>
 * <li>POST /api/v1/auth/sign-in</li>
 * <li>POST /api/v1/auth/sign-up</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Authentication", description = "Authentication Endpoints")
public class AuthenticationController {
    private final UserCommandService userCommandService;

    public AuthenticationController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    /**
     * Handles the sign-up request.
     * 
     * @param signUpResource the sign-up request body.
     * @return the created user resource.
     */
    @PostMapping("/sign-up")
    public ResponseEntity<UserResource> signUp(@RequestBody SignUpResource resource) {
        var signUpCommand = SignUpCommandFromResourceAssembler.toCommandFromResource(resource);
        var user = userCommandService.handle(signUpCommand);

        if (user.isEmpty())
            return ResponseEntity.badRequest().build();

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());

        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    /**
     * Handles the sign-in request.
     * 
     * @param signInResource the sign-in request body.
     * @return the authenticated user resource.
     */
    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticatedUserResource> signIn(@RequestBody SignInResource resource) {
        var signInCommand = SignInCommandFromResourceAssembler.toCommandFromResource(resource);
        var authenticatedUser = userCommandService.handle(signInCommand);

        if (authenticatedUser.isEmpty())
            return ResponseEntity.notFound().build();

        var authenticatedUserResource = AuthenticatedUserResourceFromEntityAssembler
                .toResourceFromEntity(authenticatedUser.get());

        return new ResponseEntity<>(authenticatedUserResource, HttpStatus.OK);
    }
}
