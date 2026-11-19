package com.crm.Mock;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrg {
		public static void main(String[] args) throws IOException, InterruptedException {
			//read common data from properties file
			FileInputStream fis=new FileInputStream("C:\\Users\\Bharathi PC\\OneDrive\\Desktop\\data\\commondata.properties");
			Properties pObj=new Properties();
			pObj.load(fis);
			
			String BROWSER=pObj.getProperty("browser");
			String URL=pObj.getProperty("url");
			String USERNAME=pObj.getProperty("username");
			String PASSWORD=pObj.getProperty("password");

			
			
			//generate the random number
			Random random=new Random();
			int randomInt=random.nextInt(10000);
			
			//read TSData from Excel file
			FileInputStream fis1=new FileInputStream("C:\\Users\\Bharathi PC\\OneDrive\\Desktop\\data\\Mockdata.xlsx");
			Workbook wb=WorkbookFactory.create(fis1);
			Sheet sh=wb.getSheet("mock");
			Row row=sh.getRow(1);
			String orgName=row.getCell(2).toString()+randomInt;
			String contactLastName=row.getCell(3).getStringCellValue();
			wb.close();
				
			
			
			WebDriver driver=null;
			
			if(BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
			}else {
				driver=new ChromeDriver();
			}
			//Step 1:login to app
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("http://49.249.29.4:8888");
			Thread.sleep(2000);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(2000);
			//navigate to Organization module
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Thread.sleep(2000);
			
			//verify Header info Expected Result
			Thread.sleep(2000);
			String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerInfo.contains(orgName)) {
				System.out.println(orgName + " is created==PASS");
			}else {
				System.out.println(orgName  + " is not created==FAIL");
			}
			
			
			//Navigate to Contacts module
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			driver.findElement(By.name("lastname")).sendKeys(contactLastName);
			Thread.sleep(2000);
			
			//click on lookUp before save as it is integration Test case
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			Thread.sleep(2000);
			//switch To child Window
			Set<String>set=driver.getWindowHandles();
			Iterator<String> it=set.iterator();//Create iterator first
			Thread.sleep(2000);
			//if we want to capture data from set collection
			while(it.hasNext()) {
				String windowID=it.next();
				driver.switchTo().window(windowID);
				Thread.sleep(2000);
				
				//capture title of the page
				String actUrl=driver.getCurrentUrl();
				if(actUrl.contains("module=Accounts")) {
					break;
				}
			}
			
			
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			Thread.sleep(2000);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
			//switch To parent window
			Set<String>set1=driver.getWindowHandles();
			Iterator<String> it1=set1.iterator();
			
			//Create iterator first
			while(it1.hasNext()) {
				String windowID=it1.next();
				driver.switchTo().window(windowID);
				
				String actUrl=driver.getCurrentUrl();
				if(actUrl.contains("Contacts&action")) {
					break;
				}
			}
			
			
			
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			
			headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerInfo.contains(contactLastName)) {
				System.out.println(contactLastName + " is created==PASS");
			}else {
				System.out.println(contactLastName + " is not created==FAIL");
			}
			
			
			//verify Header orgName info Expected Result
			String actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
			if(actOrgName.equals(actOrgName)) {
				System.out.println(orgName + " is created==PASS");
			}else {
				System.out.println(orgName + " is not created==FAIL");
			}

			
			//driver.quit();
		}

	}
