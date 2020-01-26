package main.java;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Cao Lei on 24/3/17.
 */

@WebListener
public class ApplicationStartUpListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		Utils.log("---- initialize servlet context -----");

		if (CommonShared.is_debug) {
			Utils.log("[Running] Debug Mode.");
		} else {
			Utils.log("[Running] PROD Mode.");
		}

		// add initialization code here
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		Utils.log("---- destroying servlet context -----");
		// clean up resources
	}
}