
/**
 * Created by Cao Lei on 24/3/17.
 */

package main.java;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import main.java.Entity.ResponseSuccessWithMessage;

@Path("/")
public class mainService {

	public static final int TIMEOUT = 10; // In seconds
	GsonBuilder builder = new GsonBuilder();
	Gson gson = builder.create();

	@Context
	ServletContext servletContext;

	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "Running Successfully -- Help Wu Han..";

		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/testJson")
	@Produces(MediaType.TEXT_PLAIN)
	public Response testJson(InputStream incomingData) {
		String result = "";

		ResponseSuccessWithMessage resp = new ResponseSuccessWithMessage("success", "this is a success json message");

		result = gson.toJson(resp);

		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
}
