package com.kellylyke.service;

import com.kellylyke.service.com.kellylyke.service.user.UserService;
import com.kellylyke.service.congress.MemberService;
import com.kellylyke.service.vote.VoteService;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/service") //You may want to add a value here so that all traffic isn't routed to the class below.

//The java class declares root resource and provider classes
public class UserApplication extends Application {

    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(JacksonFeature.class);
        h.add(UserService.class );
        h.add(MemberService.class);
        h.add(VoteService.class);
        return h;
    }
}