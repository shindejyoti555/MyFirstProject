package MyFirstProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends FirstProj {

	  WebDriverWait wait;

    // Locators for product elements
    private By productTitles = By.cssSelector(".product-item .product-item-name a");
    private By productImages = By.cssSelector(".product-item img");
    private By productPrices = By.cssSelector(".product-item .price");
    private By addToCartButton = By.cssSelector("#product-addtocart-button > span:nth-child(1)");
    private By cartConfirmationMessage = By.cssSelector(".message-success > div:nth-child(1)"); 
    private By cartCount = By.cssSelector(".minicart-wrapper .counter-number");
    
 // Locators for the color and size options
    

    private By sizeOption(String size) {
        return By.cssSelector(".swatch-attribute.size .swatch-option.text[aria-label='"+ size +"']");
    }
    private By colorOption(String color) {
        return By.cssSelector(".swatch-attribute.color .swatch-option.color[aria-label='"+ color +"']");
    }
    
    public ProductPage(WebDriver driver) {
    	super(driver);
    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    }

    public List<WebElement> getProductTitles() {
        return driver.findElements(productTitles);
    }

    public List<WebElement> getProductImages() {
        return driver.findElements(productImages);
    }

    public List<WebElement> getProductPrices() {
        return driver.findElements(productPrices);
    }

    public void selectColor(String color) {
        WebElement colorElement = driver.findElement(colorOption(color));
        if (colorElement.getTagName().equals("select")) {
            Select select = new Select(colorElement);
            select.selectByVisibleText(color);
        } else {
            // For non-select elements (like buttons or links)
            colorElement.findElement(By.xpath("//*[@aria-label='" + color + "']")).click();
        }
    }

    public void selectSize(String size) {
        WebElement sizeElement = driver.findElement(sizeOption(size));
        if (sizeElement.getTagName().equals("select")) {
            Select select = new Select(sizeElement);
            select.selectByVisibleText(size);
        } else {
            // For non-select elements (like buttons or links)
            sizeElement.findElement(By.xpath("//*[@aria-label='" + size + "']")).click();
        }
    }

    
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getCartCount() {
        return driver.findElement(cartCount).getText();
    }

    public boolean isCartConfirmationDisplayed() {
        return driver.findElement(cartConfirmationMessage).isDisplayed();
    }

    public String getCartConfirmationMessage() {
        return driver.findElement(cartConfirmationMessage).getText();
    }
}
	
