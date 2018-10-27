package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
	
	public static Properties loadProperties(String url) {
		Properties prop = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream(url);
			prop.load(is);
		}catch(IOException e){
			System.out.println(e.toString());
		}
		return prop;
}
}
