package com.abhi.atm.webSocket;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AtmWebSocketController {

	@GetMapping(value = "/session")
	@SendTo("/valid")
	public String getWebSocketMessage() {
		System.out.println("Publishing data for web socket client..");
		return "Message from ATM Web Socket";
	}
}
