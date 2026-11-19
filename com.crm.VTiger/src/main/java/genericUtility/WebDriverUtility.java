package genericUtility;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	public void switchToTabOnUrl(WebDriver driver,String url) {
		Set<String> allWindows=driver.getWindowHandles();
		for(String window:allWindows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}

}
