package com.restTutorial.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.restTutorial.models.User;

@Component
@Path("/users/{user_id}/recipes")
public class UserRecipeService {
	@GET
	@Produces("application/json")
	public Response getUser(@PathParam("id") Long id){
		
		System.out.println("HERE");

		return Response.ok().build();
	
	}
}
