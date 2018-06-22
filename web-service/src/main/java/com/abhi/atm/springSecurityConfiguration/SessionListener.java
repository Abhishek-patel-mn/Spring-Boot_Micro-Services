package com.abhi.atm.springSecurityConfiguration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
 
@Component
public class SessionListener implements HttpSessionListener {
 
	@Autowired
	SimpMessagingTemplate template;
	
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("==== Session is created ==== " + event.getSession().getId());
        event.getSession().setMaxInactiveInterval(10);
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("==== Session is destroyed ==== " + event.getSession().getId());
        if(template != null)
        	template.convertAndSend("/valid", "sessionDestroyed");
    }
}