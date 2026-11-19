package com.BaseTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class BaseClass {
	public WebDriver driver=null;
	public FileUtility futil=new FileUtility();
	public ExcelUtility eutil=new ExcelUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public JavaUtility jutil=new JavaUtility();
	
	@BeforeClass
	//Launching Browser
	public void ConfigBC() throws IOException {
		String BROWSER=futil.getDataFromProperties("browser");
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		
	}
	@BeforeMethod
	public void ConfigBM() throws IOException {
	//Login
	String URL=futil.getDataFromProperties("url");
	driver.get(URL);
	
	String USERNAME=futil.getDataFromProperties("username");
	String PASSWORD=futil.getDataFromProperties("password");
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	
	}
	

}
