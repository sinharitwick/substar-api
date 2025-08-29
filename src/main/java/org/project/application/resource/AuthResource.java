package org.project.application.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.project.application.dto.LoginRequest;
import org.project.application.dto.LoginResponse;
import org.project.application.dto.SignUpRequest;
import org.project.application.dto.UserResponse;
import org.project.application.service.AuthService;

@Path("/api/v1/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {
    @Inject
    AuthService authService;

    @POST
    @Path("/signup")
    public Response signUpUser(SignUpRequest request) {
        return Response.ok(authService.signUpUser(request)).build();
    }

    @POST
    @Path("/login")
    public Response loginUser(LoginRequest request) {
        return Response.ok(authService.loginUser(request)).build();
    }
}
