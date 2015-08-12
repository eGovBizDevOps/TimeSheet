package Timesheet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IntegratedTest {
   public static void main(String[] args) throws InterruptedException {
	  int i = 0;
      // Instantiate the RC Server
	  System.out.println(i+1);
      WebDriver driver = new FirefoxDriver();
      
      System.out.println(i+1);
      driver.manage().window().maximize();

      driver.get("http://localhost:8080/Application");
      System.out.println(i+1);
      

      String name = driver.findElement(By.id("head")).getText();//Locating element by class name and store its text to variable datentime.
      System.out.println(name);

      System.out.println(i+1);

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
      System.out.println(i+1);
      
      driver.findElement(By.xpath(".//*[@id='j_idt6']/input[7]")).click();
      System.out.println(i+1);
      
      driver.quit();
   }
}
