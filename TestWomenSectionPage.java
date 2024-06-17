package MyFirstProject;

	import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	
	import java.time.Duration;
	import java.util.List;

	import static org.testng.Assert.assertTrue;

	public class TestWomenSectionPage {
	    private WebDriver driver;
	    WebDriverWait wait;
	    private FilterNsortingWomenSectionPage filterNsortwomenSectionPage;

	    @BeforeMethod
	    public void setUp() {
	    	driver=new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://magento.softwaretestingboard.com/"); // URL of the Home Page
	        
	        //click on Women Section
	        driver.findElement(By.cssSelector("#ui-id-4")).click();
	        
	        //click on Category TOP
	        driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[1]/div[2]/dl/dd/ol/li[1]/a")).click();
	        filterNsortwomenSectionPage = new FilterNsortingWomenSectionPage(driver);
	    }
	
	    @Test
	    public void testFilterByCategory() {
	    	filterNsortwomenSectionPage.applyTopsCategoryFilter();
	        List<WebElement> productCategories = filterNsortwomenSectionPage.getProductCategories();
	        for (WebElement category : productCategories) {
	            assertTrue(category.getText().contains("Jackets"), "Product category should be 'Jackets'");
	        }
	    }

	    @Test
	    public void testFilterByPriceRange() {
	    	filterNsortwomenSectionPage.applyPriceRangeFilter();
	        List<WebElement> productPrices = filterNsortwomenSectionPage.getProductPrices();
	        for (WebElement price : productPrices) {
	            String priceText = price.getText().replaceAll("[^0-9.]", "");
	            double productPrice = Double.parseDouble(priceText);
	            assertTrue(productPrice >= 20.00 && productPrice <= 29.99, "Product price should be within the range of $20.00 - $29.99");
	        }
	    }

	    @Test
	    public void testFilterByColor() {
	    	filterNsortwomenSectionPage.applyBlueColorFilter();
	        List<WebElement> productColors = filterNsortwomenSectionPage.getProductColors();
	        for (WebElement color : productColors) {
	            assertTrue(color.getAttribute("aria-label").contains("Blue"), "Product color should be 'Blue'");
	        }
	    }

	    @Test
	    public void testFilterBySize() {
	    	filterNsortwomenSectionPage.applyMediumSizeFilter();
	        List<WebElement> productSizes = filterNsortwomenSectionPage.getProductSizes();
	        for (WebElement size : productSizes) {
	            assertTrue(size.getAttribute("aria-label").contains("XS"), "Product size should be 'XS'");
	        }
	    }

	   @Test
	    public void testSortByPriceLowToHigh() {
	    	filterNsortwomenSectionPage.sortByPriceLowToHigh();
	        List<WebElement> productPrices = filterNsortwomenSectionPage.getProductPrices();
	        double previousPrice = 0.0;
	        for (WebElement price : productPrices) {
	            String priceText = price.getText().replaceAll("[^0-9.]", "");
	            double currentPrice = Double.parseDouble(priceText);
	            assertTrue(currentPrice >= previousPrice, "Product prices should be sorted in ascending order");
	            previousPrice = currentPrice;
	        }
	    }

	    @Test
	    public void testSortByPriceHighToLow() {
	    	filterNsortwomenSectionPage.sortByPriceHighToLow();
	        List<WebElement> productPrices = filterNsortwomenSectionPage.getProductPrices();
	        double previousPrice = Double.MAX_VALUE;
	        for (WebElement price : productPrices) {
	            String priceText = price.getText().replaceAll("[^0-9.]", "");
	            double currentPrice = Double.parseDouble(priceText);
	            assertTrue(currentPrice <= previousPrice, "Product prices should be sorted in descending order");
	            previousPrice = currentPrice;
	        }
	    }

	    @Test
	    public void testSortByNameAToZ() {
	    	filterNsortwomenSectionPage.sortByNameAToZ();
	        List<WebElement> productNames = filterNsortwomenSectionPage.getProductNames();
	        String previousName = "";
	        for (WebElement name : productNames) {
	            String currentName = name.getText();
	            assertTrue(currentName.compareTo(previousName) >= 0, "Product names should be sorted alphabetically from A to Z");
	            previousName = currentName;
	        }
	    }

	    @Test
	    public void testSortByNameZToA() {
	    	filterNsortwomenSectionPage.sortByNameZToA();
	        List<WebElement> productNames = filterNsortwomenSectionPage.getProductNames();
	        String previousName = "ZZZZZZZZZZ";
	        for (WebElement name : productNames) {
	            String currentName = name.getText();
	            assertTrue(currentName.compareTo(previousName) <= 0, "Product names should be sorted alphabetically from Z to A");
	            previousName = currentName;
	        }
	    }


	    @AfterMethod
	    public void tearDown() {
	    	if (driver != null) {
	            //driver.quit();
	        }
	    }

	   
}
