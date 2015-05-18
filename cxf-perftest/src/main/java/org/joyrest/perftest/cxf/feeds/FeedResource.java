package org.joyrest.perftest.cxf.feeds;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.joyrest.perftest.common.model.FeedEntry;

@Path("feeds")
public class FeedResource {

	@POST
	@Consumes(APPLICATION_JSON)
	@Produces({ APPLICATION_XML, APPLICATION_JSON })
	public Response create(FeedEntry feed) {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}

		return Response.ok(feed).build();
	}

	@GET
	@Produces(APPLICATION_JSON)
	public Response getAll() {
		FeedEntry entry = new FeedEntry();
		entry.setAuthor("Mr. George Somebody");
		entry.setTitle("How to find the best REST Framework");
		entry.setDescription("Description about How to find the best REST Framework");

		List<FeedEntry> entries = new ArrayList<>();
		IntStream.range(1, 50).forEach(n -> entries.add(entry));

		return Response.ok(new GenericEntity<List<FeedEntry>>(entries) {}).build();
	}

	@GET
	@Path("ping")
	public Response ping() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) { }

		return Response.noContent().build();
	}

}
