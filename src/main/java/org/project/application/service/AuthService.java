package org.project.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.project.application.dto.LoginRequest;
import org.project.application.dto.LoginResponse;
import org.project.application.dto.SignUpRequest;
import org.project.application.dto.UserResponse;
import org.project.common.utils.JwtUtility;
import org.project.common.utils.PasswordUtility;
import org.project.domain.model.User;
import org.project.infrastructure.repository.UserRepository;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class AuthService {
    @Inject
    UserRepository userRepository;

    public UserResponse signUpUser(SignUpRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new WebApplicationException("User already exists", Response.Status.CONFLICT);
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(PasswordUtility.hashPassword(request.getPassword()));
        user.setUserName(request.getUserName());

        userRepository.persistUser(user);

        return new UserResponse(user.getUserId(), user.getEmail(), user.getUserName());
    }

    public LoginResponse loginUser(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        if(userOpt.isEmpty()) {
            throw new NotAuthorizedException("Invalid email or password");
        }

        User user = userOpt.get();

        if(!PasswordUtility.checkPassword(request.getPassword(), user.getPassword())) {
            throw new NotAuthorizedException("Invalid email or password");
        }

        String token = JwtUtility.createJWT(user.getUserId(), user.getEmail(), Set.of("USER"));

        return new LoginResponse(token);
    }
}
