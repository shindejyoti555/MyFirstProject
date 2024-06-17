package MyFirstProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends FirstProj {

	     //WebDriver driver;
	    private By firstNameField = By.id("firstname");
	    private By lastNameField = By.id("lastname");
	    private By emailField = By.id("email_address");
	    private By passwordField = By.id("password");
	    private By confirmPasswordField = By.id("password-confirmation");
	    private By registerButton = By.cssSelector("button[title='Create an Account']");
	    private By welcomeMessage = By.cssSelector(".base");

	    public RegistrationPage(WebDriver driver) {
	    	super(driver);
	    }

	    public void enterFirstName(String firstName) {
	        driver.findElement(firstNameField).sendKeys(firstName);
	    }

	    public void enterLastName(String lastName) {
	        driver.findElement(lastNameField).sendKeys(lastName);
	    }

	    public void enterEmail(String email) {
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void enterConfirmPassword(String confirmPassword) {
	        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	    }

	    public void clickRegister() {
	        driver.findElement(registerButton).click();
	    }

	    public boolean isRegistrationSuccessful() {
	        return driver.findElement(welcomeMessage).isDisplayed();
	    }
	    
	    
	    
	}
	

