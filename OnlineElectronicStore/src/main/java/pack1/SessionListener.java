package pack1;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener {
	@Override
	public void sessionCreated(HttpSessionEvent sre) {
		System.out.println("Session Object Initialized");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent sre) {
		System.out.println("Session Object Distroyed");
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		System.out.println("Attribute added to the  Object");
		System.out.println("Attribute Name: "+hsbe.getName());
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe) {
		System.out.println("Attribute remove to the  Object");
	}

}
