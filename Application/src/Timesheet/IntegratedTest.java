package Timesheet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IntegratedTest {
   public static void main(String[] args) throws InterruptedException {
   
      // Instantiate the RC Server
      WebDriver driver = new FirefoxDriver();
      

      driver.manage().window().maximize();

      driver.get("http://localhost:8080/Application");
      

      String name = driver.findElement(By.id("head")).getText();//Locating element by class name and store its text to variable datentime.
      System.out.println(name);
      

      driver.findElement(By.name("eid")).sendKeys("1012");
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.findElement(By.name("date")).sendKeys("10/03/2015");
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.findElement(By.name("timein")).sendKeys("7:15am");
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      driver.findElement(By.name("timeout")).sendKeys("6:00pm");
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
      driver.findElement(By.xpath(".//*[@id='j_idt6']/input[7]")).click();
      
      driver.quit();
   }
}