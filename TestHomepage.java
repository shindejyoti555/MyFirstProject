package MyFirstProject;

	import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.Set;
import java.util.concurrent.TimeUnit;

	public class TestHomepage {
	    private WebDriver driver;
	    private Homepage homePage;

	    @BeforeMethod
	    public void setUp() {
	        //WebDriverManager.chromedriver().setup();
	        //driver = new ChromeDriver();
	    	driver=new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.get("https://magento.softwaretestingboard.com/");
	        homePage = new Homepage(driver);
	    }

	  //Test for web site Logo displayed or not on home page 
	    @Test
	    public void testLogoDisplayed() {
	        assertTrue(homePage.isLogoDisplayed(), "Logo should be displayed on the homepage.");
	    }

	  //Test for search box displayed or not on home page 
	    @Test
	    public void testSearchBoxDisplayed() {
	        assertTrue(homePage.isSearchBoxDisplayed(), "Search box should be displayed on the homepage.");
	    }
	    
	  //Test for shopping cart displayed or not on home page 
	    @Test
	    public void testShoppingCartDisplayed() {
	        assertTrue(homePage.isShoppingCartDisplayed(), "Shopping Cart should be displayed on the homepage.");
	    }

	  //Test for search button displayed or not on home page 
	    
	    @Test
	    public void testSearchButtonDisplayed() {
	        assertTrue(homePage.isSearchButtonDisplayed(), "Search button should be displayed on the homepage.");
	    }

	  //Test for featured product displayed or not on home page  
	    @Test
	    public void testFeaturedProductDisplayed() {
	        assertTrue(homePage.isFeaturedProductDisplayed(), "At least one featured product should be displayed on the homepage.");
	    }

	  //Test for Click on sign in link  
	    @Test
	    public void testSignInLink() {
	        homePage.clickSignIn();
	        assertTrue(driver.getCurrentUrl().contains("customer/account/login"), "Sign In link should navigate to login page.");
	    }

	  //Test for Click on forgot password link  
	    @Test
	    public void testforgotPassword() {
	        
	        homePage.forgotPassword();
	        assertTrue(driver.getCurrentUrl().contains("customer/account/forgotpassword"), "Sign In link should navigate to forgot password page.");
	        driver.navigate().back();
	    }
	//Test for Click on create account link   
	    @Test
	    public void testCreateAccountLink() {
	        homePage.clickCreateAccount();
	        assertTrue(driver.getCurrentUrl().contains("customer/account/create"), "Create Account link should navigate to account creation page.");
	    }

	 // Test for Search Items
	    
	    @DataProvider(name = "searchTerms")
	    public Object[][] getSearchTerms() {
	        return new Object[][] {
	            {"Kurtis"},
	            {"jeans"},
	            {"jacket"}
	        };
	    }

	    @Test(dataProvider = "searchTerms")
	    public void testSearchFunctionality(String searchTerm) {
	        homePage.enterSearchTerm(searchTerm);
	        homePage.clickSearchButton();
	        assertTrue(homePage.isSearchResultsDisplayed(), "Search results should be displayed for the term: " + searchTerm);
	    }
	    
//Test to verify title of the Web Site
	    @Test
	    public void testverifyTitle() {
	    	String title= "Home Page";
	       String actualTitle= homePage.verifyTitle();
	       System.out.println(title);
	       System.out.println(actualTitle);
	   	
	   	if(actualTitle.equals(title))
	   	{
	   		System.out.println("Test case passed, title matches");
	   	}
	   	
	   	else
	   	{
	   		System.out.println("Test case Failed");
	   	}
	}

	  //Test for Window handle from home page to Yoga items page but test fails as Yoga Page is not open as new window tab
	    @Test
	    public void testWindowHandling() {
	        // Store the current window handle
	        String mainWindowHandle = driver.getWindowHandle();
	        assertNotNull(mainWindowHandle, "Main window handle should not be null.");
	        
	        // Click the link that opens a new window
	        homePage.clickNewWindowLink();
	        
	        // Wait for the new window to open
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // Get all window handles
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        assertNotNull(allWindowHandles, "All window handles should not be null.");

	        String newWindowHandle = null;
	        // Find the new window handle
	        for (String handle : allWindowHandles) {
	        	
	            if (!handle.equals(mainWindowHandle)) {
	            	WebElement finalWindowElement = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img"));
                    System.out.println("Text in final window: " + finalWindowElement.getText());
	            	newWindowHandle = handle;
	            	break;
	                 }
	           }
	     // Ensure the new window handle is not null
	        assertNotNull(newWindowHandle, "New window handle should not be null.");
	     // Switch to the new window and verify its content
	        driver.switchTo().window(newWindowHandle);

	        // Verify the new window's title 
	        String newWindowTitle = "New Luma Yoga Collection"; 
	        assertTrue(driver.getTitle().contains(newWindowTitle), "New window title should match the expected value.");
	        
	        // Close the new window
	        //driver.close();
	        
	        // Switch back to the main window
	        driver.switchTo().window(mainWindowHandle);
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            //driver.quit();
	        }
	    }
	}
	

