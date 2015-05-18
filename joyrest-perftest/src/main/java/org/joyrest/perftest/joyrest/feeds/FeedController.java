package org.joyrest.perftest.joyrest.feeds;

import static org.joyrest.model.http.MediaType.JSON;
import static org.joyrest.routing.entity.RequestType.Req;
import static org.joyrest.routing.entity.ResponseCollectionType.RespList;
import static org.joyrest.routing.entity.ResponseType.Resp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.joyrest.model.http.HttpStatus;
import org.joyrest.model.request.Request;
import org.joyrest.model.response.Response;
import org.joyrest.perftest.common.model.FeedEntry;
import org.joyrest.routing.TypedControllerConfiguration;

public class FeedController extends TypedControllerConfiguration {

	@Override
	protected void configure() {
		setGlobalPath("feeds");

		post((req, resp) -> {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

			resp.entity(req.getEntity());
			resp.status(HttpStatus.OK);
		}, Req(FeedEntry.class), Resp(FeedEntry.class))
			.consumes(JSON).produces(JSON);

		get(FeedController::getAll, RespList(FeedEntry.class))
			.produces(JSON);

		get("ping", (req, resp) -> {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

			resp.status(HttpStatus.NO_CONTENT);
		});
	}

	public static void getAll(Request<?> req, Response<List<FeedEntry>> resp) {
		FeedEntry entry = new FeedEntry();
		entry.setAuthor("Mr. George Somebody");
		entry.setTitle("How to find the best REST Framework");
		entry.setDescription("Description about How to find the best REST Framework");

		List<FeedEntry> entries = new ArrayList<>();
		IntStream.range(1, 50).forEach(n -> entries.add(entry));

		resp.entity(entries);
		resp.status(HttpStatus.OK);
	}
}
