package Timesheet;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IntegratedTest {
   public static void main(String[] args) throws InterruptedException {
   
      // Instantiate the RC Server
      WebDriver driver;
	try {
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.firefox());
	      

	      driver.manage().window().maximize();

	      driver.get("http://localhost:8080/Application");
	      

	      String name = driver.findElement(By.id("head")).getText();//Locating element by class name and store its text to variable datentime.
	      System.out.println(name);
	      

	      driver.findElement(By.xpath(".//*[@id='j_idt6']/input[2]")).sendKeys("@@@@");
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      driver.findElement(By.xpath(".//*[@id='j_idt6']/input[3]")).sendKeys("@@@@@@@@");
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      driver.findElement(By.xpath(".//*[@id='j_idt6']/input[4]")).sendKeys("10/03/2015");
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      driver.findElement(By.xpath(".//*[@id='j_idt6']/input[5]")).sendKeys("7:15am");
	      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	      driver.findElement(By.xpath(".//*[@id='j_idt6']/input[6]")).sendKeys("6:00pm");
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      
	      driver.findElement(By.xpath(".//*[@id='j_idt6']/input[7]")).click();
	      
	      driver.quit();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
