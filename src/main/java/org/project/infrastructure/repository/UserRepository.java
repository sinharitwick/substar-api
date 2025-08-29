package org.project.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.project.domain.model.User;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    public List<User> findAllUsers() {
        return listAll();
    }

    public Optional<User> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    @Transactional
    public void persistUser(User user) {
        persist(user);
    }
}
