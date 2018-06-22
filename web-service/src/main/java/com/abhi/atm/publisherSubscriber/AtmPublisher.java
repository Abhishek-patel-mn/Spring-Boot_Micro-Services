package com.abhi.atm.publisherSubscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmPublisher {

	@Autowired
	ApplicationEventPublisher publisher;
	
	@GetMapping(value = "/rest/publish")
	public void publish() {
		System.out.println("publishing custom atmAtm..");
		publisher.publishEvent(new AtmEvent(this));
	}
}
