package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	public Properties init_prop()
	{
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/env.properties");
			prop.load(fis);
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		
		return prop;
	}

}
