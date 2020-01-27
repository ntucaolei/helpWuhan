package main.java.search;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.java.CommonShared;
import main.java.Entity.ResponseSuccessWithMessage;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

@Path("/search")
public class SynthesizeSearchService {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    @Context
    ServletContext servletContext;
    @GET
    @Path("/queryDemandByCondition/{topicType}/{topicStatus}/{itemType}/{content}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response queryDemandByCondition(InputStream incomingData,
                                           @PathParam("topicType") String topicType,
                                           @PathParam("topicStatus") String topicStatus,
                                           @PathParam("itemType") String itemType,
                                           @PathParam("content") String content) {
        String result = "";

        if (SearchDBHelper.getLocalDBHelper() != null) {
            List<Object> list = TopicTypeEnums.queryByCondition( topicType, topicStatus, itemType, content);
            result = builder.create().toJson(list);
            ResponseSuccessWithMessage resp = new ResponseSuccessWithMessage("success", result);
            result = gson.toJson(resp);
            return Response.status(200).entity(result).build();
        }else {
            return CommonShared.returnDBError();
        }
    }
}
