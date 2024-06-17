package MyFirstProject;


	import io.github.bonigarcia.wdm.WebDriverManager;
	import org.openqa.selenium.WebDriver;
	
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

	public class TestLogin {
	     WebDriver driver;
	     private Homepage homePage;
	    private LoginPage loginPage;

	    @BeforeMethod
	    public void setUp() {
	    	driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        homePage = new Homepage(driver);
	        loginPage = new LoginPage(driver);
	        driver.get("https://magento.softwaretestingboard.com/");
	        
	    }

	    @DataProvider(name = "loginData")
	    public Object[][] getLoginData() {
	        ExcelUtilsData excelUtilsData = new ExcelUtilsData("D:\\Jyoti\\Selenium\\Projects\\MyFirstProject\\ExcelData.xlsx", "LoginData");
	        return excelUtilsData.getTestData();
	    }

	    @Test(dataProvider = "loginData")
	    public void testLogin(String email, String password, String expectedResult) {
	    	homePage.clickSignIn();
	        loginPage.enterEmail(email);
	        loginPage.enterPassword(password);
	        loginPage.clickLogin();
	        //loginPage.clickLogOut();

	        //assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
	        
	        if (expectedResult.equals("success")) {
	            assertTrue(loginPage.isLoginSuccessful(), "Expected login to be successful");
	        } else {
	            assertFalse(loginPage.isLoginSuccessful(), "Expected login to fail");
	            String errorMsg = loginPage.getErrorMessage();
	            assertTrue(errorMsg.contains("Invalid login or password."), "Expected error message not found.");
	        }
	    }

	    
	    
	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}