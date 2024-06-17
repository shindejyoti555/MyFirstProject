package MyFirstProject;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import java.time.Duration;
	import java.util.List;

	public class FilterNsortingWomenSectionPage extends FirstProj {
	    //private WebDriver driver;
	    private WebDriverWait wait;

	    // Constructor
	    public FilterNsortingWomenSectionPage(WebDriver driver) {
	    	super(driver);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	
	 // Locators
	    private By topsCategoryFilter = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[2]/ol/li[1]/a");
	    private By priceRangeFilter = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[12]/div[2]/ol/li[1]");
	    private By blueColorFilter = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[5]/div[2]/div/div/a[2]/div");
	    private By mediumSizeFilter = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div/div/a[1]/div");
	    private By sortByDropdown = By.cssSelector(".sorter-options");
	    private By sortByPriceLowToHigh = By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[4]/select/option[3]");
	    private By sortByPriceHighToLow = By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[4]/select/option[3]");
	    private By sortByNameAToZ = By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[4]/select/option[2]");
	    private By sortByNameZToA = By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[4]/select/option[2]");
	    private By getproductCategories = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[1]");
	    private By productPrices = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[12]/div[1]");
	    private By productColors = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[5]/div[1]");
	    private By productSizes = By.cssSelector(".size-wrapper");
	    private By productNames = By.cssSelector(".product-item-name");
	    private By Descending = By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[4]/a");
	    private By Ascending = By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[4]/a");
	    private By productList = By.cssSelector(".product-items .product-item");
	    // Methods
	    public void applyTopsCategoryFilter() {
	    	WebElement sizeElement =wait.until(ExpectedConditions.elementToBeClickable(topsCategoryFilter));
	    	scrollToElement(sizeElement);
	    	sizeElement.click();
	    	waitForProductsToLoad();
	        //wait.until(ExpectedConditions.elementToBeClickable(topsCategoryFilter)).click();
	    }

	    public void applyPriceRangeFilter() {
	    	WebElement sizeElement =wait.until(ExpectedConditions.elementToBeClickable(priceRangeFilter));
	    	scrollToElement(sizeElement);
	    	sizeElement.click();
	    	waitForProductsToLoad();
	        //wait.until(ExpectedConditions.elementToBeClickable(priceRangeFilter)).click();
	    }

	    public void applyBlueColorFilter() {
	    	
	    	WebElement sizeElement =wait.until(ExpectedConditions.elementToBeClickable(blueColorFilter));
	    	scrollToElement(sizeElement);
	    	sizeElement.click();
	    	waitForProductsToLoad();
	    }

	    public void applyMediumSizeFilter() {
	    	WebElement sizeElement =wait.until(ExpectedConditions.elementToBeClickable(mediumSizeFilter));
	    	scrollToElement(sizeElement);
	    	sizeElement.click();
	    	waitForProductsToLoad();
	        //wait.until(ExpectedConditions.elementToBeClickable(mediumSizeFilter)).click();
	    }

	    public void sortByPriceLowToHigh() {
	        wait.until(ExpectedConditions.elementToBeClickable(sortByDropdown)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(sortByPriceLowToHigh)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(Ascending)).click();
	    }

	    
	    public void sortByPriceHighToLow() {
	        wait.until(ExpectedConditions.elementToBeClickable(sortByDropdown)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(sortByPriceHighToLow)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(Descending)).click();
	    }

	    public void sortByNameAToZ() {
	        wait.until(ExpectedConditions.elementToBeClickable(sortByDropdown)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(sortByNameAToZ)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(Descending)).click();
	    }

	    public void sortByNameZToA() {
	        wait.until(ExpectedConditions.elementToBeClickable(sortByDropdown)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(sortByNameZToA)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(Ascending)).click();
	    }

	    public List<WebElement> getProductCategories() {
	        return driver.findElements(getproductCategories);
	    }
	    
	    public List<WebElement> getProductPrices() {
	        return driver.findElements(productPrices);
	    }
	    
	    public List<WebElement> getProductColors() {
	        return driver.findElements(productColors);
	    }
	    
	    public List<WebElement> getProductSizes() {
	        return driver.findElements(productSizes);
	    }

	    public List<WebElement> getProductNames() {
	        return driver.findElements(productNames);
	    }
	
	    private void scrollToElement(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    }
	 // Method to wait for products to load
	    private void waitForProductsToLoad() {
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));
	    }

	    // Method to get product list
	    public List<WebElement> getProductList() {
	        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));
	    }

}
