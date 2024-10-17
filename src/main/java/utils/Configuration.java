package utils;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
	// this represents a persistent set of properties
	private Properties properties = new Properties();
	
	public Configuration() {
		loadproperty();
	}
	
	public void loadproperty() {
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperties(String Key) {
		return properties.getProperty(Key);
	}
	
}
