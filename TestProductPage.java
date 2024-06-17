package MyFirstProject;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

	public class TestProductPage {
	     WebDriver driver;
	     WebDriverWait wait;
	    private ProductPage productPage;
	    //private HomePage homePage;

	    @BeforeMethod
	    public void setUp() {
	        
	        driver=new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.get("https://magento.softwaretestingboard.com/");
	        //homePage = new HomePage(driver);
	        productPage = new ProductPage(driver);
	    }

	    @Test
	    public void testProductTitlesPresence() {
	        List<WebElement> productTitles = productPage.getProductTitles();
	        assertFalse(productTitles.isEmpty(), "Product titles should be displayed on the homepage.");
	        for (WebElement title : productTitles) {
	            assertFalse(title.getText().isEmpty(), "Product title should not be empty.");
	        }
	        System.out.println("title");
	    }

	    @Test
	    public void testProductImagesPresence() {
	        List<WebElement> productImages = productPage.getProductImages();
	        assertFalse(productImages.isEmpty(), "Product images should be displayed on the homepage.");
	        for (WebElement image : productImages) {
	            assertTrue(image.isDisplayed(), "Product image should be displayed.");
	        }
	    }

	    @Test
	    public void testProductPricesPresence() {
	        List<WebElement> productPrices = productPage.getProductPrices();
	        assertFalse(productPrices.isEmpty(), "Product prices should be displayed on the homepage.");
	        for (WebElement price : productPrices) {
	            assertFalse(price.getText().isEmpty(), "Product price should not be empty.");
	        }
	        System.out.println("price");
	    }

	    @Test
	    public void testAddProductToCart() throws InterruptedException {
	    	// Select color and size
	    	driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/a/span/span/img")).click();
	    	//Thread.sleep(1000); 
	    	productPage.selectSize("S"); 
	        //Thread.sleep(1000);  
	        productPage.selectColor("Blue");
	        // Click the "Add to Cart" button
	        productPage.clickAddToCart();

	        // Explicit wait for the confirmation message or cart count update
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(driver -> productPage.isCartConfirmationDisplayed() || Integer.parseInt(productPage.getCartCount()) > 0);

	        // Assert that the cart confirmation message is displayed
	        assertTrue(productPage.isCartConfirmationDisplayed(), "Cart confirmation message should be displayed.");
	        
	        // Optional: Verify the cart confirmation message content
	        String expectedMessage = "You added Radiant Tee to your shopping cart."; 
	        assertTrue(productPage.getCartConfirmationMessage().contains(expectedMessage), "Cart confirmation message should contain the expected text.");

	        // Assert that the cart count has increased (assuming it starts from 0)
	        assertTrue(Integer.parseInt(productPage.getCartCount()) > 0, "Cart count should be greater than 0 after adding a product.");
	    }


	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}

