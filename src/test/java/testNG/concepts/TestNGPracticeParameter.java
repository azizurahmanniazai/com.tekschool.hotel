package testNG.concepts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestNGPracticeParameter {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test
	@Parameters({ "url" })
	public void navigateToURL(String url) {
		driver.get(url);
		String actualTitle = driver.getTitle();
		String expectedTitle = "TEK SCHOOL";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertAll();
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}