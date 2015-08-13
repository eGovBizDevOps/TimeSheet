package Timesheet;

import java.util.concurrent.TimeUnit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IntegratedTest {
   public static String text = "\n<!DOCTYPE>\n<html>\n<title>suite1</title>\n<style>\n.failed {color: black; background-color: #ffcccc;}\n.passed {color: black; background-color: #ccffcc;}\n.done {color: black; background-color: #FFFFAD;}\n.comment {color: #404040; background-color: #d0d0d0;}\nbody, table { font-family: Verdana, Arial, sans-serif; font-size: 12pt; }\ntable { border-collapse: collapse; border: 1px solid #ccc; }\nth, td { padding-left: 0.3em; padding-right: 0.3em; border: 1px solid #ccc; }\n#suiteSummaryTable thead { font-size: 14pt; font-weight: 800; }\n.test_case thead { font-size: 14pt; font-weight: 400; }\n</style>\n</head>\n<body>\n<table>\n<thead>\n<tr><td colspan=\"4\">Test case: suite1</td></tr>\n</thead><tbody>\n";
   public static String fields[] = {"Username", "Date", "Time In", "Time Out", "Password"};
   public static String record[] = {"@@@@", "10/03/2015", "7:15am", "6:00pm", "password"};
   public static void main(String[] args) throws InterruptedException {
      // Instantiate the RC Server
      WebDriver driver = new FirefoxDriver();
      System.out.println(text);
      
      driver.manage().window().maximize();

      driver.get("http://localhost:8080/Application/");
      
      String name = driver.findElement(By.id("head")).getText();//Locating element by class name and store its text to variable datentime.
      System.out.println(name);
      
      for(int i = 0; i<5; i++){
    	  driver.findElement(By.xpath(".//*[@id='j_idt6']/input[" + (i+2) + "]")).sendKeys(record[i]);
    	  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	      text += "<tr class=\"done\">\n\t<td>Execute</td>\n\t<td>" + fields[i] + "</td>\n\t<td>" + record[i] + "</td>\n\t<td>PERFORMED</td>\n<tr>\n";
      }
      
      driver.findElement(By.xpath(".//*[@id='j_idt6']/input[7]")).click();
      
      for(int i = 1; i<5; i++){
	      String field = driver.findElement(By.xpath("html/body/p["+i+"]")).getText();
	      if(field.contains(record[i-1])){
	    	  text += "<tr class=\"passed\">\n\t<td>Display</td>\n\t<td>" + fields[i-1] + "</td>\n\t<td>" + record[i-1] + "</td>\n\t<td>SUCCESS</td>\n<tr>\n";
	      }
	      else{
	    	  text += "<tr class=\"failed\">\n\t<td>Display</td>\n\t<td>" + fields[i-1] + "</td>\n\t<td>" + record[i-1] + "</td>\n\t<td>FAILURE</td>\n<tr>\n";
	      }
      }
      System.out.println(text);
      text += "</tbody></table>\n</body>\n</html>";
      driver.quit();
/***************************************FILE***************************************/      
      try {

			String content = text;

			File file = new File("results.html");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
      
   }
}
