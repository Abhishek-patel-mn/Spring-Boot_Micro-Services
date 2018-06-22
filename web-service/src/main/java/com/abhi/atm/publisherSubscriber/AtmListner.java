package com.abhi.atm.publisherSubscriber;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AtmListner implements ApplicationListener<AtmEvent> {

	@Override
	public void onApplicationEvent(AtmEvent atmEvent) {
		System.out.println("Received spring custom event - " + atmEvent.getMessage());
	}

}
