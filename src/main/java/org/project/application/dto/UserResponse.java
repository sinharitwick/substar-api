package org.project.application.dto;

import java.time.ZonedDateTime;
import java.util.Set;

public class UserResponse {
    private Long userId;
    private String email;
    private String username;
    private Set<String> roles;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public UserResponse() {
    }

    public UserResponse(Long userId, String email, String username, Set<String> roles, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.roles = roles;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserResponse(Long userId, String email, String username) {
        this.userId = userId;
        this.email = email;
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
