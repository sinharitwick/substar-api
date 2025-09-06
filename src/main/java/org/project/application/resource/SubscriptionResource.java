package org.project.application.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.project.application.dto.SubscriptionRequest;
import org.project.application.service.SubscriptionService;

import java.util.UUID;

@Path("/api/v1/subscriptions")
@RolesAllowed("USER")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubscriptionResource {
    @Inject
    SubscriptionService subscriptionService;

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("/categories")
    public Response getUserCategories () {
        UUID userId = UUID.fromString(jwt.getClaim("userId").toString());
        return Response.ok(subscriptionService.getUserCategories(userId)).build();
    }

    @GET
    public Response getSubscriptionsByCategory(@QueryParam("category") String category) {
        UUID userId = UUID.fromString(jwt.getClaim("userId").toString());
        return Response.ok(subscriptionService.getUserSubscriptionsByCategory(userId, category)).build();
    }

    @POST
    public Response addSubscription(@Valid SubscriptionRequest request) {
        UUID userId = UUID.fromString(jwt.getClaim("userId").toString());
        return Response.ok(subscriptionService.addSubscription(userId, request)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateSubscription(@PathParam("id") UUID subscriptionId, @Valid SubscriptionRequest request) {
        UUID userId = UUID.fromString(jwt.getClaim("userId").toString());
        return Response.ok(subscriptionService.updateSubscription(userId, subscriptionId, request)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSubscription(@PathParam("id") UUID subscriptionId) {
        UUID userId = UUID.fromString(jwt.getClaim("userId").toString());
        subscriptionService.deleteSubscription(userId, subscriptionId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
