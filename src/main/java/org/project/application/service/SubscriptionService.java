package org.project.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.project.application.dto.SubscriptionRequest;
import org.project.domain.model.Subscription;
import org.project.domain.model.User;
import org.project.infrastructure.repository.SubscriptionRepository;
import org.project.infrastructure.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SubscriptionService {
    @Inject
    SubscriptionRepository subscriptionRepository;

    @Inject
    UserRepository userRepository;

    public List<String> getUserCategories(Long userId) {
        return subscriptionRepository.list("user.userId", userId).stream()
                .map(Subscription::getCategory)
                .distinct()
                .toList();
    }

    public List<Subscription> getUserSubscriptionsByCategory(Long userId, String category) {
        return subscriptionRepository.findSubscriptionsByUserIdAndCategory(userId, category);
    }

    public Subscription addSubscription(Long userId, SubscriptionRequest request) {
        User user = userRepository.findById(userId);
        if(user == null) {
            throw new RuntimeException("User not found");
        }
        Subscription s = new Subscription();
        s.setUser(user);
        s.setCategory(request.getCategory());
        s.setServiceName(request.getServiceName());
        s.setStatus("ACTIVE");
        subscriptionRepository.persistSubscription(s);
        return s;
    }

    @Transactional
    public Subscription updateSubscription(Long userId, Long subscriptionId, SubscriptionRequest request) {
        User user = userRepository.findById(userId);
        if(user == null) {
            throw new RuntimeException("User not found");
        }
        Subscription s = subscriptionRepository.findByIdAndUserId(subscriptionId, userId);
        s.setCategory(request.getCategory());
        s.setServiceName(request.getServiceName());
        s.setStatus("ACTIVE");
        return s;
    }

    @Transactional
    public void deleteSubscription(Long userId, Long subscriptionId) {
        Subscription s = subscriptionRepository.findByIdAndUserId(subscriptionId, userId);
        subscriptionRepository.delete(s);
    }
}
