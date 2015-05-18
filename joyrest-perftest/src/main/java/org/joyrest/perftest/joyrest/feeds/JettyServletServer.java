package org.joyrest.perftest.joyrest.feeds;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.joyrest.servlet.ServletApplicationHandler;

public class JettyServletServer {

	public static void main(String[] args) throws Exception {
		Server server = new Server(5000);

		ServletContextHandler context = new ServletContextHandler();
		context.setContextPath("/services");
		context.addServlet(new ServletHolder(
				new ServletApplicationHandler(new ApplicationConfig(), null)), "/*");
		server.setHandler(context);

		server.start();
		server.join();
	}
}
