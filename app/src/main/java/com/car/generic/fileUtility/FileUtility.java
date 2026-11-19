package com.car.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./ConfigCarData/carcommondata.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(key);
		return value;
	}
	public String getDataFromPropertiesFileForAdmin(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./ConfigCarData/adminlogin.commondata.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(key);
		return value;
	}	

}
