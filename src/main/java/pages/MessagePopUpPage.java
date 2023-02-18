package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage{

    public MessagePopUpPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

//   -------METODE----------------------------------------------

    public void waitForPopUpToShowUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='v-snack__wrapper v-sheet theme--dark error']")));
    }

    public WebElement getTextElement() {
        return driver.findElement
                (By.xpath("//div[@class='v-snack__wrapper v-sheet theme--dark error']/div/ul/li"));
    }

    public WebElement getCloseButton() {
        return driver.findElement
                (By.xpath("//button[@class='v-btn v-btn--text theme--dark v-size--default']"));
    }

    public void waitForVerifyYourAccountPopUp() {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='v-card v-sheet theme--light']")));
    }

    public WebElement verifyYourAccountBannerHeader() {
        return driver.findElement
                (By.xpath("//div[@class='v-card v-sheet theme--light']/div"));
    }

    public WebElement closeButtonFromVerifyYourAccountBanner() {
        return driver.findElement
                (By.xpath("//div[@class='v-card__actions']/button"));
    }

    public WebElement getVerifyMessage() {
        return driver.findElement(By.xpath("//input[@id='name']"));
    }

    public void waitForSmallPopUpToShowUp() {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By
                        .xpath("//div[@class='v-snack__wrapper v-sheet theme--dark success']")));
    }

    public WebElement getNewCityField() {
        return driver.findElement(
                By.xpath("//div[@class='v-text-field__slot']/input[@id='name']"));
    }

    public void clearInputField() {
        WebElement element = driver.findElement
                (By.xpath("//div[@class='v-text-field__slot']/input[@id='name']"));
        for (int i = 0; i < 50; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public WebElement verifyHeader() {
        return driver.findElement
                (By.xpath("//*[contains(@class,'display-2')]"));
    }

}
