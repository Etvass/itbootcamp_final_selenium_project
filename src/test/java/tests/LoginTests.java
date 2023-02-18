package tests;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{

    @Test
    @Description("Setup english as page language and verifaing that login page can load")
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='v-toolbar__items']/button")).click();
        driver.findElement(By.xpath("//div[@role='menuitem']")).click();
        driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[3]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test
    @Description("")
    public void ChecksInputTypes() {
        driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[3]")).click();
        Assert.assertEquals(loginPage.enterImail().getAttribute("type"), "email",
                "This attribute does not have 'email' value");
        Assert.assertEquals(loginPage.enterPassword().getAttribute("type"),"password",
                "This attribute does not have 'password' value");
    }

    @Test
    @Description("")
    public void DisplaysErrorsWhenUserDoesNotExist() {
        navPage.loginOnHomePage().click();
        loginPage.enterImail().sendKeys("non-existing-user@gmal.com");
        loginPage.enterPassword().sendKeys("password123");
        loginPage.loginButton().click();
        messagePopUpPage.waitForPopUpToShowUp();
        Assert.assertEquals(messagePopUpPage.getTextElement(),"User does not exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    @Description("")
    public void DisplaysErrorsWhenPasswordIsWrong() {
        navPage.loginOnHomePage().click();
        loginPage.enterImail().sendKeys("admin@admin.com");
        loginPage.enterPassword().sendKeys("password123");
        loginPage.loginButton().click();
        messagePopUpPage.waitForPopUpToShowUp();
        Assert.assertEquals(messagePopUpPage.getTextElement(),"Wrong password");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    @Description("")
    public void Login() {
        navPage.loginOnHomePage().click();
        loginPage.enterImail().sendKeys("admin@admin.com");
        loginPage.enterPassword().sendKeys("12345");
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @Test
    @Description("")
    public void Logout() {
        Assert.assertTrue
                (helper.elementExist(driver, By.xpath("//div[@class='v-toolbar__items']/button[2]")));
        navPage.logoutButton().click();
    }

}
