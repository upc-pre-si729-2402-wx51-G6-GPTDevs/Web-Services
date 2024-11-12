package com.tasklinker.tasklinker.iam.interfaces.rest.transform;

import com.tasklinker.tasklinker.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(String token) {
        return new AuthenticatedUserResource(token);
    }
}
