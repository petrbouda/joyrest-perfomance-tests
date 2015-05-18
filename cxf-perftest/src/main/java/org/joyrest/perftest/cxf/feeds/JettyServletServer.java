package org.joyrest.perftest.cxf.feeds;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServletServer {

	public static void main(String[] args) throws Exception{
		Server server = new Server(5000);

		WebAppContext context = new WebAppContext();
		context.setResourceBase("./cxf-perftest/src/main/webapp");
		context.setContextPath("/");
		context.setParentLoaderPriority(true);

		server.setHandler(context);

		server.start();
		server.join();
	}
}
