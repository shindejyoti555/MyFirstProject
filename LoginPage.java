package MyFirstProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends FirstProj{
    //private WebDriver driver;

    // Locators
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By loginButton = By.name("send");
    private By errorMessage = By.cssSelector(".message-error");
    private By welcomeMessage = By.cssSelector(".base");
   // private By logOutButton = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
    

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    
    public boolean isLoginSuccessful() {
        return driver.findElement(welcomeMessage).isDisplayed();
    }
    
   /* public void clickLogOut() {
        driver.findElement(logOutButton).click();
    }*/
    
}
	

