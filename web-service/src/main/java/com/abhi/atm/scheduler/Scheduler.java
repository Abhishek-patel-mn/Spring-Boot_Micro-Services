package com.abhi.atm.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * @author Abhishek Patel M N Jan 17, 2018
 */
@Component
public class Scheduler {
	
	@Autowired
	SimpMessagingTemplate template;
	
	final int scheduleTime = 10000;
	@Scheduled(fixedDelay = scheduleTime)
	private void scheduler() {
		System.out.println("************ THIS IS SPRING BOOT SCHEDULER FOR " + scheduleTime + " MILLISECINDS ************");
		//template.convertAndSend("/valid", "sessionDestroyed");
	}
}
