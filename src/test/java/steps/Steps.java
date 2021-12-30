package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    private WebDriver driver;

    @After
    public void tearDown(){
        driver.quit();
    }

    @Before
    public void setUp(){
        BasicConfigurator.configure();
        System.setProperty("webdriver.chrome.driver","resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @Given("I am in google search page")
    public void i_am_in_google_search_page() {
        driver.get("https://www.google.com/");
    }

    @When("I search for a word in google")
    public void iSearchForAWordInGoogle() {
        driver.findElement(By.xpath(".//input[@type='text']")).sendKeys("cars");
        driver.findElement(By.cssSelector(".aajZCb>.lJ9FBc>center>input[name='btnK']")).click();
    }

    @Then("I should be in the search page")
    public void iShouldBeInTheSearchPage() {
        String text=driver.findElement(By.cssSelector(".ekf0x >.iJ1Kvb>h3")).getText();
        Assert.assertTrue(text.contains("cars"));
    }
}
