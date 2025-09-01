package org.project.application.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.project.application.dto.SubscriptionRequest;
import org.project.application.service.SubscriptionService;

@Path("/api/v1/subscriptions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubscriptionResource {
    @Inject
    SubscriptionService subscriptionService;

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("/categories")
    @RolesAllowed("USER")
    public Response getUserCategories () {
        Long userId = Long.valueOf(jwt.getClaim("userId").toString());
        return Response.ok(subscriptionService.getUserCategories(userId)).build();
    }

    @GET
    @RolesAllowed("USER")
    public Response getSubscriptionsByCategory(@QueryParam("category") String category) {
        Long userId = Long.valueOf(jwt.getClaim("userId").toString());
        return Response.ok(subscriptionService.getUserSubscriptionsByCategory(userId, category)).build();
    }

    @POST
    @RolesAllowed("USER")
    public Response addSubscription(SubscriptionRequest request) {
        Long userId = Long.valueOf(jwt.getClaim("userId").toString());
        return Response.ok(subscriptionService.addSubscription(userId, request)).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("USER")
    public Response deleteSubscription(@PathParam("id") Long subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
