package MyFirstProject;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
	

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

	public class TestCases {
	    WebDriver driver;
	    //WebDriverWait wait;
	    public static JavascriptExecutor js;
	    //ExcelUtil excelUtil;
	    private Homepage homePage;
	    private RegistrationPage registrationPage;

	    @BeforeMethod
	    public void setUp() {
	        
	        driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	        homePage = new Homepage(driver);
	         registrationPage = new RegistrationPage(driver);
	      // Navigate to the home page
	         driver.get("https://magento.softwaretestingboard.com/");
		}
	    
     
	    @DataProvider(name = "registrationData")
	    public Object[][] getRegistrationData() {
	    	
	        String excelPath = "D:\\Jyoti\\Selenium\\Projects\\MyFirstProject\\ExcelData.xlsx";
	        String sheetName = "RegistrationData";
	        Object data[][] = ExcelUtil.getTestData(excelPath, sheetName);
	        return data;
	    }

	    @Test(dataProvider = "registrationData")
	    public void testValidUserRegistration(String firstName, String lastName, String email, String password, String confirmPassword) {
	    	
	        
	    	homePage.clickCreateAccount();
	        registrationPage.enterFirstName(firstName);
	        registrationPage.enterLastName(lastName);
	        registrationPage.enterEmail(email);
	        registrationPage.enterPassword(password);
	        registrationPage.enterConfirmPassword(confirmPassword);
	        registrationPage.clickRegister();

	        // Add assertions to verify successful registration
	        assertTrue(registrationPage.isRegistrationSuccessful(), "Registration was not successful.");
	    }
	       
	 
	    @AfterMethod
	    public void tearDown() {
	    	// Close the browser
	        //if (driver != null) {
	            driver.quit();
	        //}
	    }
	}
	
