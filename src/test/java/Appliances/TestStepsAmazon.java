package Appliances;

import java.time.Duration;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestStepsAmazon {
		//launch amazon application
		//click search in amazon
		//Enter TV and submit
		//Get tv title
	static WebDriver driver;
	
	@BeforeClass
	public static void launchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	public void method1() {
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("TV",Keys.ENTER);
	}
	
	@Test
	public void method2() {
		List<WebElement> tvTitles=driver.findElements(By.xpath("//h2[contains(@aria-label,'TV')]//span"));
		System.out.println("Amazon tv list: ");
		for(WebElement title:tvTitles) {
			System.out.println(title.getText());
		}
		
	}
	
	@AfterClass
	public static void quitBrowser() {
		driver.quit();
	}
	
}
