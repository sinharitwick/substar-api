package org.project.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.project.domain.model.Subscription;

import java.util.List;

@ApplicationScoped
public class SubscriptionRepository implements PanacheRepository<Subscription> {
    public List<Subscription> findAllSubscriptionsByUserId(Long userId) {
        return list("user.userId", userId);
    }

    public List<Subscription> findSubscriptionsByUserIdAndCategory(Long userId, String category) {
        return list("user.userId = ?1 and category = ?2", userId, category);
    }

    public Subscription findByIdAndUserId(Long subscriptionId, Long userId) {
        return find("id = ?1 and user.userId = ?2", subscriptionId, userId).firstResult();
    }

    @Transactional
    public void persistSubscription(Subscription subscription) {
        persist(subscription);
    }
}
