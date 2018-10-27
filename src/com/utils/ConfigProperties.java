package com.utils;

import java.util.Properties;

public class ConfigProperties {
	
	private static ConfigProperties instance;
	private static Properties props;
	
	private ConfigProperties() {
		props = Util.loadProperties(System.getProperty("user.dir") + "\\config\\config.properties");
	}
	
	
	public static ConfigProperties getInstance() {
		if(instance == null) {
			synchronized (ConfigProperties.class) {
				if(instance == null) {
					instance = new ConfigProperties();
				}
			}
		}
		return instance;
	}
	
	public String getProperty(String property) {
		return props.getProperty(property);
	}
	
}
