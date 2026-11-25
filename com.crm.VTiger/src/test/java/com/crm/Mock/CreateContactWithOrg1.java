package com.crm.Mock;
	import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import com.BaseTest.BaseClass;

	public class CreateContactWithOrg1 extends BaseClass {
		public void CreateConOrg() throws EncryptedDocumentException, IOException, InterruptedException {
			driver.findElement(By.linkText("Organizations")).click();
			// click on + icon
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			// Enter details
			// reading data from excel sheet

			String orgName = eutil.getDataFromExcel("mock",1, 2) + jutil.generateRandom();
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Thread.sleep(2000);
			
			String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerInfo.contains(orgName)) {
				System.out.println(orgName + " is displayed==PASS");
			}else {
				System.out.println(orgName  + " is not displayed==FAIL");
			}
			

			// Navigate to contacts link
			driver.findElement(By.linkText("Contacts")).click();

			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

			// Workbook wb = WorkbookFactory.create(fis1);
			String contactName = eutil.getDataFromExcel("mock", 1, 3) + jutil.generateRandom();
			driver.findElement(By.name("lastname")).sendKeys(contactName);
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			// switch to child window
			wutil.switchToTabOnUrl(driver, "module=Accounts");
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			//switch to parent window
			wutil.switchToTabOnUrl(driver, "module=Contacts");
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			// verify header message
			String actHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (actHeader.contains(contactName)) {
			System.out.println(contactName + " informantion is displayed ,test Script= PASS");
			} else {
			System.out.println(contactName + " informantion is not displayed ,test Script= FAIL");
			}

			// Verifying the contactName
			String actcontactName = driver.findElement(By.id("dtlview_Last Name")).getText();
			if (actcontactName.contains(contactName)) {
			System.out.println(contactName + " informantion is displayed,test Script= PASS");
			} else {
			System.out.println(contactName + " informantion is not displayed,test Script= FAIL");
			}
			
			

			/*// Verifying the orgName
			String actorgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			if (actorgName.trim().equals(orgName)) {
			System.out.println(orgName + " informantion is displayed test Script= PASS");
			} else {
			System.out.println(orgName + " informantion is not displayed test Script= FAIL");
			}	*/

		

	}


}
