package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{

    @Test
    @Description("")
    public void VisitsTheAdminCitiesPageAndListCities() {
        navPage.loginOnHomePage().click();
        loginPage.enterImail().sendKeys("admin@admin.com");
        loginPage.enterPassword().sendKeys("12345");
        loginPage.loginButton().click();
        navPage.adminButton().click();
        navPage.citiesFromAdmin().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
    }

    @Test
    @Description("")
    public void ChecksInputTypesForCreateEditNewCity() {
        navPage.adminButton().click();
        navPage.citiesFromAdmin().click();
        citiesPage.newItemButton().click();
        citiesPage.waitForEditDialog();
        citiesPage.waitForDialogToBeDisplayed();
        Assert.assertEquals(messagePopUpPage.getVerifyMessage().getAttribute("type"),
                "text",
                "This attribute does not have 'text' value");
    }

    @Test
    @Description("")
    public void CreateNewCity() {
        navPage.adminButton().click();
        navPage.citiesFromAdmin().click();
        citiesPage.newItemButton().click();
        citiesPage.waitForDialogToBeDisplayed();
        citiesPage.getInputForNewItem().sendKeys("Nis");
        citiesPage.saveButtonInEditDialog();
        messagePopUpPage.waitForSmallPopUpToShowUp();


    }

    @Test
    @Description("")
    public void Editcity() {
        navPage.adminButton().click();
        navPage.citiesFromAdmin().click();
        citiesPage.searchInput().sendKeys("Nis");
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.getEditButtonForRow(1).click();
        messagePopUpPage.clearInputField();
        messagePopUpPage.getNewCityField().sendKeys("Lukas city");
        citiesPage.saveButtonInEditDialog().click();
        messagePopUpPage.waitForSmallPopUpToShowUp();

    }

    @Test
    @Description("")
    public void SearhCity() {
        navPage.adminButton().click();
        navPage.citiesFromAdmin().click();
        citiesPage.searchInput().sendKeys("Nis");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertEquals(citiesPage.getCellByRowAndColumn(1,1).getText(),"Nis");
    }

    @Test
    @Description("")
    public void DeleteCity() {
        navPage.adminButton().click();
        navPage.citiesFromAdmin().click();
        citiesPage.searchInput().sendKeys("Nis");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertEquals(citiesPage.getCellByRowAndColumn(1,1).getText(),"Nis");
        citiesPage.getDeleteButtonForRow(1).click();
        citiesPage.waitForDialogToBeDisplayed();
        citiesPage.deleteButtonInDeleteDialog().click();
        messagePopUpPage.waitForSmallPopUpToShowUp();

    }

}
