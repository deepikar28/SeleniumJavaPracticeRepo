package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import open.browser.OpenBrowserTest;

public class PropertiesFile {
	static Properties prop = new Properties();

	public static void main(String[] args) {

		readPropertiesFile();
		writePropertiesFile();
		readPropertiesFile();
	}
	
//read properties file
	public static void readPropertiesFile() {

		try {
			InputStream input = new FileInputStream("/Users/deepika/eclipse-workspace/firstselenium/src/test/java/config/config.properties");
			prop.load(input);
			OpenBrowserTest.browser= prop.getProperty("browser");
			System.out.println(OpenBrowserTest.browser);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	

	}
	
	//write properties file
	public static void writePropertiesFile() {

		try {
			OutputStream output = new FileOutputStream("/Users/deepika/eclipse-workspace/firstselenium/src/test/java/config/config.properties");
			prop.setProperty("browser", "chrome");
			prop.setProperty("OS", "Mac");
			prop.store(output, "");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
