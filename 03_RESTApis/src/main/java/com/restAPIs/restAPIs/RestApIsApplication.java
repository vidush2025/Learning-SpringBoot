package com.restAPIs.restAPIs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RestApIsApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestApIsApplication.class, args);
	}
	@EventListener
	public void onServerReady(WebServerInitializedEvent event) {
		int port = event.getWebServer().getPort();
		System.out.println("🚀 Server started at port: " + port);
	}

}
