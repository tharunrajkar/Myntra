package proj;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/saranraj/eclipse/Testing/Automation/Drivers/chromedriver-mac-arm64/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://www.myntra.com/");
		
		Actions act=new Actions(driver);

		WebElement mini = driver.findElement(By.xpath("(//a[@class='desktop-main'])[3]"));
		act.moveToElement(mini).build().perform();
		
        WebElement tshirt = driver.findElement(By.xpath("//a[text()='T-Shirts']"));
        act.moveToElement(tshirt).build().perform();
        act.click(tshirt).build().perform();
        
        List<WebElement> price = driver.findElements(By.xpath("//div[@class='product-price']"));
        int prod= price.size();
        
        System.out.println("total no of products: "+prod);
        
        for (WebElement webElement : price) {
        	System.out.println(webElement.getText());
			
		}
		
	}

}