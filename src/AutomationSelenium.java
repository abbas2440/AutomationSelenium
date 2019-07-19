import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AutomationSelenium {

	@Test
	public void site_header_is_on_home_page() {

		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\gecko\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver browser = new FirefoxDriver();
		
		
		browser.get("https://www.mashreqbank.com/uae/en/personal/home");

		
		browser.get("https://www.mashreqbank.com/uae/en/news/");
		//browser.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		browser.get("https://www.mashreqbank.com/uae/en/personal/contactus");
		//browser.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		browser.findElement(By.id("btnSubmit")).submit();
		
		System.out.println(browser.switchTo().alert().getText());
		browser.switchTo().alert().accept();
		
		System.out.println("Fields which required are as follows:");
		System.out.println("(1).First Name");
		System.out.println("(2).Email");
		System.out.println("(3).Mobile Number");
		browser.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Select prodLook =new Select(browser.findElement(By.id("reachoutforproduct")));
		prodLook.selectByVisibleText("I am Looking to...");
		browser.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
	    browser.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		WebElement number;
		
		browser.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		//browser.findElement(By.id("reachoutforproduct"));
		Select prodLoan = new Select(browser.findElement(By.id("need")));
		prodLoan.selectByVisibleText("Loans");
		
		
		browser.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		number=browser.findElement(By.id("mobile"));
			number.sendKeys("565423");
			
		browser.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);	
		number=browser.findElement(By.name("mobile"));
			number.sendKeys("5654239");
		
		System.out.println(browser.switchTo().alert().getText());

			//driver.switchTo().alert().sendKeys("fesfe");

		browser.switchTo().alert().accept(); //Accept = ok done yes
		//List<WebElement> allLinks=browser.findElements(By.tagName("div"));
		//for(int i=0;i<allLinks.size();i++) {
		//	System.out.println(allLinks.get(i).getText());
		//}
		//browser.findElement(By.linkText("Log In")).click();
		//textbox=browser.findElement(By.cssSelector("div#app"));
		//textbox=browser.findElement(By.xpath("//input[@id='Ist-ib']"));
		//textbox.sendKeys("Hello");
		//WebElement header = browser.findElement(By.id("app"));
			//	   header.sendKeys("sensor04");
				//   header.getSize();
		//String attValue = header.getAttribute("text");
		//assertTrue((header.isDisplayed()));

		browser.close();
	//	 System.out.println("Successfully opened the website");
		 
			//Wait for 5 Sec
			
			
	        // Close the driver
	        browser.quit();
	}

}