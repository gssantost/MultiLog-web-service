package com.utils;

import java.util.Properties;

public class Prop {

    private Properties props;

    public Prop() {
        props = Util.loadProperties(System.getProperty("user.dir") + "\\config\\config.properties");
    }

    public String getProperty(String property) {
        return props.getProperty(property);
    }
}
