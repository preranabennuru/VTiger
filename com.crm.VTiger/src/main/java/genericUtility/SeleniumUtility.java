package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;
/*
 * This is utility class which has functionality from Selenium library
 */

public class SeleniumUtility {
	/*
	 * This is generic method to access a web application
	 * @param driver
	 * @param url
	 */
	public void accessApplication(WebDriver driver,String url) {
		driver.get(url);
	}
	/*
	 * This is generic method to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/*
	 * generic method to refresh webpage
	 * @param driver
	 */
	public void refreshWebpage(WebDriver driver) {
		driver.navigate().refresh();
	}
	/*
	 * generic method to close the browser
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	/*Generic method to provide implicit wait
	 * @param driver
	 * @param maxTime
	 */
	public void implicitWait(WebDriver driver,int maxTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
	}
	/////***********Handling DropDown***********////////
	/*
	 * Generic method to select an option in dropdown using value attribute
	 * @param dropdownEle
	 * @param value
	 */
	public void selectOptionByValue(WebElement dropdownEle,String value) {
		Select sel=new Select(dropdownEle);
		sel.selectByValue(value);
	}
	/*
	 * Generic method to select an option in dropdown using visible text
	 * @param dropdownEle
	 * @param visibleText
	 */
	public void selectOptionByVisibleText(WebElement dropdownEle,String visibleText) {
		Select sel=new Select(dropdownEle);
		sel.selectByVisibleText(visibleText);
	}
	/*
	 * Generic method to select an option in dropdown using value index
	 * @param dropdownEle
	 * @param index
	 */
	public void selectOptionByIndex(WebElement dropdownEle,int index) {
		Select sel=new Select(dropdownEle);
		sel.selectByIndex(index);
	}
	/*
	 * generic method to perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseHoveringAction(WebDriver driver,WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}
	/*
	 * generic method to perform right click action
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element) {
		new Actions(driver).contextClick(element).perform();
	}
	/*
	 * generic method to perform drag and drop action
	 * @param driver
	 * @param draggableEle
	 * @param dropEle
	 */
	public void dragAndDropAction(WebDriver driver,WebElement draggableEle,WebElement dropEle) {
		new Actions(driver).dragAndDrop(draggableEle,dropEle).perform();
	}
	/////*******Handling Alert popup****///////
	/*
	 * This is a generic method to accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/*
	 * This is a generic method to cancel alert popup
	 * @param driver
	 */
	public void canceltAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/////////*********Handling frames**********//////////
	/*
	 * This is generic method to switch to a frame using frame index
	 * @param driver
	 * @param index 
	 */
	public void switchToFrameUsingIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/*
	 * This is generic method to switch to a frame using frame webelement
	 * @param driver
	 * @param frameEle 
	 */
	public void switchToFrameUsingFrameElement(WebDriver driver,WebElement frameEle) {
		driver.switchTo().frame(frameEle);
	}
	/////////*********Take webpage Screenshot**********//////////
	/*
	 * This is generic method to capture webpage screenshot
	 * @param driver
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public String takeWebpageScreenshot(WebDriver driver,String fileName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshots\\"+fileName+".png");//Create a folder
		Files.copy(src, dest);
		return dest.getAbsolutePath(); //Used for listeners
	}
	
	





}
