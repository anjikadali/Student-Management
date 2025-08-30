package pack1;

//import javax.servlet.annotation.WebListener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

//@WebListener
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Request Object Initialized");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("Request Object Destroyed");
	}
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("Attribute Name :"+srae.getName());
	}
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("Attribute removed from the Servlet Request Removed");
	}

}
