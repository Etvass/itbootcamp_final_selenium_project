package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    public LoginPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }
//  -------METODE----------------------------------------------
    public WebElement enterImail() {
        return driver.findElement(By.xpath("//input[@id='email']"));
    }

    public WebElement enterPassword() {
        return driver.findElement(By.xpath("//input[@id='password']"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

}
