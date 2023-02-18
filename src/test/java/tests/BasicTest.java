package tests;

import Helper.Helper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class BasicTest {



    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com/";
    protected NavPage navPage;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;
    protected Helper helper;

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        navPage = new NavPage(wait, driver);
        loginPage = new LoginPage(wait, driver);
        signUpPage = new SignUpPage(wait, driver);
        messagePopUpPage=new MessagePopUpPage(wait, driver);
        citiesPage=new CitiesPage(wait, driver);
    }


    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }




    @AfterMethod
    public void afterMethod(String relativePath) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File(relativePath));
    }

    @AfterClass
    public void afterClass() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }

}
