package org.joyrest.perftest.joyrest.feeds;

import org.joyrest.context.ApplicationContext;
import org.joyrest.undertow.UndertowServer;

public class UndertowStart {

	public static void main(String[] args) {
		ApplicationConfig configurer = new ApplicationConfig();
		ApplicationContext applicationContext = configurer.initialize();

		UndertowServer.start(applicationContext, 5000, "/services");
	}
}
