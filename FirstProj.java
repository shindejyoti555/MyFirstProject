package MyFirstProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstProj {

	protected WebDriver driver;
	protected WebDriverWait wait;
	 JavascriptExecutor js;

   public FirstProj(WebDriver driver) {
	   
	   this.driver=driver;
   	this.js = (JavascriptExecutor) driver; // Casting WebDriver to JavascriptExecutor
       PageFactory.initElements(driver, this);
       
   }
	
}
