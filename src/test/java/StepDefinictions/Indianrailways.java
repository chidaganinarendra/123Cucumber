package StepDefinictions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import com.google.common.io.Files;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Indianrailways {
	
	
	WebDriver driver;
	
	@Given("User is on Navigation to home page")
	public void user_is_on_navigation_to_home_page() {
		//System.setProperty("webdriver.chrome.driver",
				//"C:\\Users\\Admin\\Downloads\\chromedriver-win32 (2)\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.get("https://www.google.co.in/");
		driver.navigate().to("https://indianrailways.gov.in/");
		driver.navigate().refresh();
		// driver.navigate().forward();
		// driver.navigate().back();

	}

	@When("User Gives the Browser_Window_Size")
	public void user_gives_the_browser_window_size() {
	    
		driver.manage().window().maximize();
	}

	@And("User Gives the ImpilicityWait")
	public void user_gives_the_impilicity_wait() {
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("User Enter the Inputbox")
	public void user_enter_the_inputbox() {
		WebElement web = driver.findElement(By.xpath("//input [@name='q']"));
		web.sendKeys("Zonal Railways");
		WebElement web1 = driver.findElement(By.xpath("//input [@type='submit']"));
		web.click();
	}

	@And("User Gives the ExpilicityWait")
	public void user_gives_the_expilicity_wait() {
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.urlContains("Home-page"));

		//driver.navigate().back();
	}

	@And("User Enter the MouseHover")
	public void user_enter_the_mouse_hover() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a [@title = 'Zonal Railways']"))).perform();
		Thread.sleep(3000);

	}

	@And("User Enter the Drop_Down")
	public void user_enter_the_drop_down() throws InterruptedException {
		WebElement Dp = driver.findElement(By.xpath("//*[@id=\'topnav\']/li[4]/a"));
		Dp.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\'topnav\']/li[4]/div/ul/li[10]/a")).click();
		//Select drpCountry = new Select(Dp);
		// drpCountry.selectByVisibleText();
		//drpCountry.selectByValue("");
		//drpCountry.selectByIndex(10);
		

		Thread.sleep(3000);
	}

	@Then("User is Gives to Scrolldown")
	public void user_is_gives_to_scrolldown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(3000);
	}

	@And("User is gives Screen_Shots")
	public void user_is_gives_screen_shots() throws IOException, InterruptedException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Files.copy(src, new File("C:\\Users\\Admin\\OneDrive\\Desktop\\Screen Shot\\GoogleScreenShot.jpg"));

		Thread.sleep(3000);
	}

	@And("Close The Browser")
	public void close_the_browser() {
		
		//driver.close();
	    
	}
}

