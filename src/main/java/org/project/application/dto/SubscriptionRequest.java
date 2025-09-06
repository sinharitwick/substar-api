package org.project.application.dto;

import jakarta.validation.constraints.*;
import org.project.domain.model.enums.BillingCycle;
import org.project.domain.model.enums.SubscriptionStatus;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class SubscriptionRequest {
    @NotBlank
    private String serviceName;

    @NotBlank
    private String category;

    @DecimalMin(value = "0.0", inclusive = false, message = "Cost must be greater than 0")
    private BigDecimal cost;

    @NotNull
    private BillingCycle billingCycle;

    @NotNull
    private SubscriptionStatus status;

    @FutureOrPresent(message = "Renewal date must be in the present or future")
    private ZonedDateTime renewalDate;

    @Size(max = 255, message = "Notes must be 255 characters or less")
    private String notes;

    public SubscriptionRequest() {
    }

    public SubscriptionRequest(String serviceName, String category, BigDecimal cost, BillingCycle billingCycle, SubscriptionStatus status, ZonedDateTime renewalDate, String notes) {
        this.serviceName = serviceName;
        this.category = category;
        this.cost = cost;
        this.billingCycle = billingCycle;
        this.status = status;
        this.renewalDate = renewalDate;
        this.notes = notes;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BillingCycle getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(BillingCycle billingCycle) {
        this.billingCycle = billingCycle;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    public ZonedDateTime getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(ZonedDateTime renewalDate) {
        this.renewalDate = renewalDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
