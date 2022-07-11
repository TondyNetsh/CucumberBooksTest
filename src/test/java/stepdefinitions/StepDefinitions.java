package stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefinitions {
    public WebDriver driver;


    @Given("^User is on landing page$")
    public void user_is_on_landing_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver","C:/Users/CQ/Documents/WebDrivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/books");
    }

    @When("^User enters (.+) and (.+) to login$")
    public void user_enters_and_to_login(String username, String password) throws Throwable {
        Thread.sleep(1000);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login']"))).click();
        Thread.sleep(1000);
        JavascriptExecutor jsScroll = ((JavascriptExecutor) driver);
        jsScroll.executeScript("window.scrollBy(0,300)", "");

        driver.findElement(By.id("userName")).sendKeys("test");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("Password01!");

        Thread.sleep(1000);
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login']"))).click();
        driver.findElement(By.id("login")).click();
        Thread.sleep(1000);
    }

    @Then("^User will see a list of books$")
    public void user_will_see_a_list_of_books() throws Throwable {
        System.out.println(driver.getTitle());
    }

    @Then("^User clicks on a book name$")
    public void user_clicks_on_a_book_name() throws Throwable {
        JavascriptExecutor jsScroll = ((JavascriptExecutor) driver);
        jsScroll.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='see-book-Programming JavaScript Applications']/a")).click();
    }

    @Then("^User adds book to collection$")
    public void user_adds_book_to_collection() throws Throwable {
        String isbn = driver.findElement(By.xpath("//div[@id='ISBN-wrapper']")).findElement(By.xpath("//div[@id='ISBN-wrapper']/div[2]")).getText();
        System.out.println("ISBN: " + isbn);

        Thread.sleep(1000);
        JavascriptExecutor jsScroll = ((JavascriptExecutor) driver);
        jsScroll.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(2000);
        driver.findElement(By.id("addNewRecordButton")).click();

        Thread.sleep(10000);
        driver.close();
    }
}


//div[@id="ISBN-wrapper"]/div[2]