package MyFirstProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends FirstProj {

	//WebDriver driver;
	private By logo = By.cssSelector("img[src*='logo']");
    private By searchBox = By.id("search");
    private By cart = By.cssSelector(".showcart");
    private By searchButton = By.cssSelector("button[title='Search']");
    private By signInLink = By.linkText("Sign In");
    private By createAccountLink = By.linkText("Create an Account");
    private By featuredProduct = By.cssSelector(".product-item");
    private By searchResults = By.cssSelector(".search.results");
    private By newWindowLink = By.cssSelector(".button");

    public Homepage(WebDriver driver)
    {
    	super(driver);
    	//this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
  //is Web site Logo displayed on home page
    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

  //is Search box displayed on home page
    public boolean isSearchBoxDisplayed() {
        return driver.findElement(searchBox).isDisplayed();
    }

  //is Search button displayed on home page
    public boolean isSearchButtonDisplayed() {
        return driver.findElement(searchButton).isDisplayed();
    }

    //is shopping cart displayed on home page
    public boolean isShoppingCartDisplayed() {
        return driver.findElement(cart).isDisplayed();
    }
    
    // navigate to sign in page
    public void clickSignIn() {
        driver.findElement(signInLink).click();
    }
    
 // navigate to sign in & forgot password page
    public void forgotPassword() {
        driver.findElement(signInLink).click();
        driver.findElement(By.linkText("Forgot Your Password?")).click();
        
    }

    //// navigate to registration page
    public void clickCreateAccount() {
        driver.findElement(createAccountLink).click();
    }
    
  //is Featured Product option displayed on home page
    public boolean isFeaturedProductDisplayed() {
        return driver.findElements(featuredProduct).size() > 0;
    }

    // check search box & button search for items we entered for search
    public void enterSearchTerm(String searchTerm) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public boolean isSearchResultsDisplayed() {
        return driver.findElements(searchResults).size() > 0;
    }
    
    public String verifyTitle() {
            return driver.getTitle();
    }
    
    public void clickNewWindowLink() {
        driver.findElement(newWindowLink).click();
    }
}