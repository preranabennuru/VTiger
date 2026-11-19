package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
		public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Bharathi PC\\OneDrive\\Desktop\\data\\MockData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;	
	}
		/*public void writeDataFromProperties(String key,String value) throws IOException {
			FileInputStream fis=new FileInputStream("C:\\Users\\Bharathi PC\\OneDrive\\Desktop\\data\\MockData.properties");
			Properties prop=new Properties();
			prop.load(fis);
			prop.setProperty(key,value);
			FileOutputStream fos=new FileOutputStream("C:\\Users\\Bharathi PC\\OneDrive\\Desktop\\data\\MockData.properties");
			prop.store(fos, "comments");
		}*/

}

