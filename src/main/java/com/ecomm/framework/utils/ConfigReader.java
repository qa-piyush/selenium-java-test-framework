package com.ecomm.framework.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

}
