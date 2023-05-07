package leaderBoard.tdd.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;





public class Configuration {
	
	private static Configuration configuration;
	private static Properties properties;
	
	private Configuration() {
	}

	private static void loadProperty(String path) {
		properties = new Properties();
		try {
			InputStream iStream = new FileInputStream(path);
			properties.load(iStream);
			iStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Configuration getInstance(String path) {
		loadProperty(path);
		if(configuration == null) {
			configuration = new Configuration();
		}
		return configuration;
	}
	
	public String get(String key) {
		if(key != null) {
			return properties.getProperty(key);
		}else {
			return null;
		}
	}



}
