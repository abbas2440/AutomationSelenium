import com.google.common.base.Verify;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationSelenium
{

	@Test
	public static void main (String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
        WebElement element;

        browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        browser.manage().window().maximize();
        System.out.println("HomePage");
        System.out.println("The navigation bar should be visible...");
        browser.get("https://www.mashreqbank.com/uae/en/personal/home");
        Assert.assertNotNull(browser.findElements(By.className("leftLinks")));
        int menuCount=browser.findElements(By.xpath("/html/body/div[2]/div[4]/div[1]/nav/div/div[1]/div/ul/li[position() >= 2]")).size();
        Assert.assertEquals(9,menuCount);

        System.out.println("The Mashreq News should be displayed on the homepage.");
        String newsMatch=browser.findElement(By.xpath("/html/body/div[2]/div[4]/div[3]/ui-view/div[1]/div[3]/div[2]/div[1]/div/h3")).getText().trim();
        Assert.assertEquals("Mashreq News",newsMatch);

        System.out.println("A link for “Contact Us” should be displayed...");
        WebElement contactUsLink=browser.findElement(By.xpath("/html/body/div[2]/div[4]/div[4]/div[3]/div/section/div/section[4]/div/a"));
        Assert.assertNotNull(contactUsLink);
        contactUsLink.click();
        String contactUs=browser.findElement(By.xpath("/html/body/div[2]/div[4]/div[3]/ui-view/div/div/form/div[1]/div[1]/h3")).getText().trim();
        Assert.assertEquals("Contact Us",contactUs);

        System.out.println("Submitting the form without entering any details...");
        browser.findElement(By.id("btnSubmit")).click();
        Verify.verifyNotNull(browser.findElement(By.id("btnSubmit")));
        Assert.assertNotNull(browser.findElement(By.id("reachoutforproduct")).getAttribute("required"));
        Assert.assertNotNull(browser.findElement(By.id("compInqServ")).getAttribute("required"));
        Assert.assertNotNull(browser.findElement(By.id("need")).getAttribute("required"));
        Assert.assertNotNull(browser.findElement(By.id("product")).getAttribute("required"));
        Assert.assertNotNull(browser.findElement(By.id("emirate")).getAttribute("required"));
        Assert.assertNotNull(browser.findElement(By.id("branch")).getAttribute("required"));
        Assert.assertNotNull(browser.findElement(By.id("prefLang")).getAttribute("required"));
        Assert.assertNotNull(browser.findElement(By.id("curStatus")).getAttribute("required"));
        Assert.assertNotNull(browser.findElement(By.id("firstName")).getAttribute("required"));
        Assert.assertNotNull(browser.findElement(By.id("email")).getAttribute("required"));
        Assert.assertNotNull(browser.findElement(By.id("mobile")).getAttribute("required"));

        System.out.println("The “I am looking to…” field is a dropdown with 4 choices\n");
        int look=browser.findElements(By.xpath("//*[@id=\"reachoutforproduct\"]/option[position()>=2]")).size();
        Assert.assertEquals(4,look);
        boolean flag=false;
        try {
            browser.findElement(By.id("product")).findElement(By.xpath("/option[@selected='selected']"));
        }
        catch(NoSuchElementException e)
        {
         flag=true;
        }
        Assert.assertTrue(flag);

        System.out.println("The “Select Sub Product” field is initially empty");
        Select prodLoan = new Select(browser.findElement(By.id("need")));
		prodLoan.selectByVisibleText("Loans");
        Select loan= new Select(browser.findElement(By.id("product")));
        loan.selectByVisibleText("Home Loan UAE Resident");
        Assert.assertNotNull(browser.findElement(By.xpath("/html/body/div[2]/div[4]/div[3]/ui-view/div/div/form/div[2]/div/div")));
        Assert.assertNotNull(browser.findElement(By.id("product")));

        System.out.println("Selecting the Product “Loans” from the dropdown...");
        int product=browser.findElements(By.xpath("//*[@id=\"product\"]/option[position()>=2]")).size();
        Assert.assertEquals(6,product);
        boolean productExist = false;
        List<WebElement> products=browser.findElements(By.xpath("//*[@id=\"product\"]/option"));
        for (WebElement we:products) {
        productExist=we.getText().trim().equals("Home Loan UAE Resident");
        if(productExist){
            break;
            }
        }
        Assert.assertTrue(productExist);

        System.out.println("Entering a number that is less than 7 digits...");
        element=browser.findElement(By.id("mobile"));
		element.sendKeys("523412");
		Assert.assertEquals("Mobile number should be 7 digit",browser.findElement(By.xpath("/html/body/div[2]/div[4]/div[3]/ui-view/div/div/form/div[2]/div/div/div[7]/div/div[2]/span")).getText().trim());
        element.sendKeys("5");
        Assert.assertEquals("",browser.findElement(By.xpath("/html/body/div[2]/div[4]/div[3]/ui-view/div/div/form/div[2]/div/div/div[7]/div/div[2]/span")).getText().trim());

		//browser.close();
		System.out.println("Excersise Complete");
		//browser.quit();
	}

}