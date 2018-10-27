package com.utils;

import java.util.Properties;

public class ApplicationProperties {
	
	private static ApplicationProperties instance;
	private static Properties props;
	
	
	private ApplicationProperties() {
		props = Util.loadProperties(System.getProperty("user.dir") + "\\config\\application.properties");
	}
	
	public static ApplicationProperties getInstance() {
		if(instance == null) {
			synchronized (ApplicationProperties.class) {
				if(instance == null) {
					instance = new ApplicationProperties();
					return instance;
				}
			}
		}
		return instance;
	}
	
	public String getProperty(String property) {
		return props.getProperty(property);
	}

}
