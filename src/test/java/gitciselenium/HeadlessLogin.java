package gitciselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessLogin {
	 private WebDriver driver;

	    @BeforeClass
	    public void setUp()
	    {
	        WebDriverManager.chromedriver().setup();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--headless");
	        driver = new ChromeDriver(options);
	        driver.navigate().to("https://example.testproject.io/web/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
	    }

	    @Test
	    public void headlessLogin() {
	    WebElement signin =	driver.findElement(By.id("name"));
	    	signin.sendKeys("TestProj");
	    WebElement passcode = driver.findElement(By.id("password"));
	    	passcode.sendKeys("12345");
	    WebElement btn_loginElement = driver.findElement(By.id("login"));
	    	btn_loginElement.click();
	    System.out.println("\n \t Current Page URL is :- "+driver.getCurrentUrl());
	    System.out.println("\n \t Current Page Title is :- "+driver.getTitle());
	    String text = driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1")).getText();
        System.out.println("\n \t MESSAGE TO BE DISPLAYED :=> "+text);
	    System.out.println("\n");
	    	
	    }

}
