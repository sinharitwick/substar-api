package org.project.application.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/v1/subscriptions")
public class SubscriptionResource {

    @GET
    public String AllSubs () {
        return "all subs";
    }

    @GET
    @Path("/categories")
    public String Categories () {
        return "all categories";
    }
}
