package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage{


    public SignUpPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

//    -------METODE----------------------------------------------

    public WebElement enterName() {
        return driver.findElement(By.xpath("//input[@name='name']"));
    }

    public WebElement enterImail() {
        return driver.findElement(By.xpath("//input[@name='email']"));
    }

    public WebElement enterPassword() {
        return driver.findElement(By.xpath("//input[@name='password']"));
    }

    public WebElement confirmPassword() {
        return driver.findElement(By.xpath("//input[@name='confirmPassword']"));
    }

    public WebElement signMeUpButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

}
