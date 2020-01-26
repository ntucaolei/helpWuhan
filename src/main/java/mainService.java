
/**
 * Created by Cao Lei on 24/3/17.
 */

package main.java;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import main.java.Entity.ContributorItemEntity;
import main.java.Entity.DemandItemEntity;
import main.java.Entity.FakeNewsItemEntity;
import main.java.Entity.ResponseError;
import main.java.Entity.ResponseSuccessWithMessage;

@Path("/")
public class mainService {

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

	@GET
	@Path("/getAllDemandList")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllDemandList(InputStream incomingData) {
		String result = "";

		if (CommonShared.getLocalDBHelper() != null) {

			List<DemandItemEntity> list = CommonShared.getLocalDBHelper().getDemandList();

			result = gson.toJson(list);

			ResponseSuccessWithMessage resp = new ResponseSuccessWithMessage("success", result);

			result = gson.toJson(resp);

			return Response.status(200).entity(result).build();

		} else {
			return CommonShared.returnDBError();
		}
	}

	@GET
	@Path("/getDemandByID/{demand_id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getDemandByID(InputStream incomingData, @PathParam("demand_id") String demand_id) {
		String result = "";

		if (this.isNullOrEmpty(demand_id)) {
			return CommonShared.returnInvalidInputError();
		}

		if (CommonShared.getLocalDBHelper() != null) {

			DemandItemEntity demand_item = CommonShared.getLocalDBHelper().getDemandByID(demand_id);

			if (isNullOrEmpty(demand_item.id)) {
				return CommonShared.returnNotFoundError();
			}

			result = gson.toJson(demand_item);

			ResponseSuccessWithMessage resp = new ResponseSuccessWithMessage("success", result);

			result = gson.toJson(resp);

			return Response.status(200).entity(result).build();

		} else {
			return CommonShared.returnDBError();
		}

	}

	@GET
	@Path("/getAllContributionList")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllContributionList(InputStream incomingData) {
		String result = "";

		if (CommonShared.getLocalDBHelper() != null) {

			List<ContributorItemEntity> list = CommonShared.getLocalDBHelper().getContributionList();

			result = gson.toJson(list);

			ResponseSuccessWithMessage resp = new ResponseSuccessWithMessage("success", result);

			result = gson.toJson(resp);

			return Response.status(200).entity(result).build();

		} else {
			return CommonShared.returnDBError();
		}
	}

	@GET
	@Path("/getContributionByID/{con_id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContributionListByID(InputStream incomingData, @PathParam("con_id") String con_id) {
		String result = "";

		if (this.isNullOrEmpty(con_id)) {
			return CommonShared.returnInvalidInputError();
		}

		if (CommonShared.getLocalDBHelper() != null) {

			ContributorItemEntity contribution_item = CommonShared.getLocalDBHelper().getContributorByID(con_id);

			if (isNullOrEmpty(contribution_item.id)) {
				return CommonShared.returnNotFoundError();
			}

			result = gson.toJson(contribution_item);

			ResponseSuccessWithMessage resp = new ResponseSuccessWithMessage("success", result);

			result = gson.toJson(resp);

			return Response.status(200).entity(result).build();

		} else {
			return CommonShared.returnDBError();
		}

	}

	@GET
	@Path("/getAllFakeNewsList")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllFakeNewsList(InputStream incomingData) {
		String result = "";

		if (CommonShared.getLocalDBHelper() != null) {

			List<FakeNewsItemEntity> list = CommonShared.getLocalDBHelper().getFakenewsList();

			result = gson.toJson(list);

			ResponseSuccessWithMessage resp = new ResponseSuccessWithMessage("success", result);

			result = gson.toJson(resp);

			return Response.status(200).entity(result).build();

		} else {
			return CommonShared.returnDBError();
		}
	}

	@GET
	@Path("/getFakeNewsByID/{fakenews_id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getFakeNewsByID(InputStream incomingData, @PathParam("fakenews_id") String fakenews_id) {
		String result = "";

		if (this.isNullOrEmpty(fakenews_id)) {
			return CommonShared.returnInvalidInputError();
		}

		if (CommonShared.getLocalDBHelper() != null) {

			FakeNewsItemEntity fakenews_item = CommonShared.getLocalDBHelper().getFakenewsByID(fakenews_id);

			if (isNullOrEmpty(fakenews_item.id)) {
				return CommonShared.returnNotFoundError();
			}

			result = gson.toJson(fakenews_item);

			ResponseSuccessWithMessage resp = new ResponseSuccessWithMessage("success", result);

			result = gson.toJson(resp);

			return Response.status(200).entity(result).build();

		} else {
			return CommonShared.returnDBError();
		}

	}

	public static boolean isNullOrEmpty(String s) {
		return s == null || s.equals("");
	}

}
