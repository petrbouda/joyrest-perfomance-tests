package org.joyrest.perftest.joyrest.feeds;

import org.joyrest.context.ApplicationContext;
import org.joyrest.context.NonDiConfigurer;
import org.joyrest.perftest.joyrest.feeds.FeedController;
import org.joyrest.utils.transform.JsonReaderWriter;

public class ApplicationConfig extends NonDiConfigurer {

	@Override
	public ApplicationContext initialize() {
		FeedController feedController = new FeedController();
		JsonReaderWriter readerWriter = new JsonReaderWriter();

		addControllerConfiguration(feedController);
		addReader(readerWriter);
		addWriter(readerWriter);

		return super.initializeContext();
	}
}
