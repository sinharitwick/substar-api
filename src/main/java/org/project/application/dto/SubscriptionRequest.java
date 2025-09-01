package org.project.application.dto;

public class SubscriptionRequest {
    private String serviceName;
    private String category;

    public SubscriptionRequest() {
    }

    public SubscriptionRequest(String serviceName, String category) {
        this.serviceName = serviceName;
        this.category = category;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
