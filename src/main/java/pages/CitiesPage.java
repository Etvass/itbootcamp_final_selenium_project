package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage {

    public CitiesPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

//   -------METODE----------------------------------------------

    public WebElement newItemButton() {
        return driver.
                findElement(By.xpath("//div[@class='text-right']/button"));
    }

    public WebElement searchInput() {
        return driver.findElement(By.xpath("//input[@id='search']"));
    }

    public void waitForEditDialog() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='v-dialog dlgNewEditItem']")));
    }

    public void waitForDeleteDialog() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='v-dialog v-dialog--active']")));
    }

    public WebElement saveButtonInEditDialog() {
        return driver.findElement(By.xpath("//div[@class='v-card__actions']/button[2]"));
    }

    public WebElement deleteButtonInDeleteDialog() {
        return driver.findElement
                (By.xpath("//button[@class='v-btn v-btn--text " +
                        "theme--light v-size--default red--text text--lighten3']"));
    }

    public void waitForNumberOfRowsToBe(int numberOfRows) {
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//*[@class='v-data-table__wrapper']"),numberOfRows));
    }

    public WebElement getCellByRowAndColumn(int row, int column) {
        return driver.findElement
                (By.xpath("//div[@class='v-data-table__wrapper']" +
                        "/table/tbody/tr["+row+"]/td["+column+"]"));
    }

    public WebElement getEditButtonForRow(int row) {
        return driver.findElement
                (By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr["+row+"]/td/div/button"));
    }

    public WebElement getDeleteButtonForRow(int row) {
        return driver.findElement
                (By.xpath("//div[@class='v-data-table__wrapper']" +
                        "/table/tbody/tr["+row+"]/td/div/button[2]"));
    }

    public void waitForDialogToBeDisplayed(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//div[contains(@class,'v-dialog--active')]")));
    }

    public WebElement getInputForNewItem() {
        return driver.findElement
                (By.xpath("//input[@id='name']"));
    }

}
