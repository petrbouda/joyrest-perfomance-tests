package org.joyrest.perftest.joyrest.feeds;

import static org.joyrest.perftest.common.GrizzlyServletStart.run;

import org.joyrest.hk2.HK2Configurer;
import org.joyrest.servlet.ServletApplicationHandler;

public class GrizzlyServletStart {

	public static void main(String[] args) {
		run(new ServletApplicationHandler(new ApplicationConfig(), null));
	}
}
