package org.project.application.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("api/v1/users")
public class UserResource {
    @GET
    @RolesAllowed({"USER"})
    public String getAllUsers() {
        return "all users";
    }
}
