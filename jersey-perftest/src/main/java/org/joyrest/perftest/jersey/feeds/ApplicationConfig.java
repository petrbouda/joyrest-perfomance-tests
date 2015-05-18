package org.joyrest.perftest.jersey.feeds;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/services")
public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {
		packages("org.joyrest.perftest.jersey");
		register(MoxyJsonFeature.class);
	}
}
