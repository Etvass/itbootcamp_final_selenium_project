package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{

    public NavPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }
//  -------METODE----------------------------------------------
    public WebElement homeButton() {
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a"));
    }

    public WebElement aboutButton() {
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[2]"));
    }

    public WebElement loginOnHomePage() {
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[3]"));
    }

    public WebElement adminButton() {
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/button"));
    }

    public WebElement citiesFromAdmin() {
        return driver.findElement(By.xpath("//a[@id='list-item-211']"));
    }

    public WebElement usersFromAdmin() {
        return driver.findElement(By.xpath("//a[@id='list-item-214']"));
    }

    public WebElement signUpButton() {
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[4]"));
    }

    public WebElement loginButtonOnLoginPage() {
        return driver.findElement(By.xpath("//div[@class='flex text-xs-center mt-5 mb-3']/button"));
    }

    public WebElement logoutButton() {
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/button[2]"));
    }

    public WebElement choseLanguageButton() {
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/button"));
    }

    public WebElement enLanguage() {
        return driver.findElement(By.xpath("//div[@id='list-item-97']"));
    }

    public WebElement esLanguage() {
        return driver.findElement(By.xpath("//div[@id='list-item-99']"));
    }

    public WebElement frLanguage() {
        return driver.findElement(By.xpath("//div[@id='list-item-101']"));
    }

    public WebElement cnLanguage() {
        return driver.findElement(By.xpath("//div[@id='list-item-103']"));
    }



}
