package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{

    @Test
    @Description("")
    public void VisitsTheSignupPage() {
        navPage.signUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    @Description("")
    public void ChecksInputTypes() {
        navPage.signUpButton().click();
        Assert.assertEquals(signUpPage.enterImail().getAttribute("type"),"email",
                "This attribute does not have 'email' value");
        Assert.assertEquals(signUpPage.enterPassword().getAttribute("type"),"password",
                "This attribute does not have 'password' value");
        Assert.assertEquals(signUpPage.confirmPassword().getAttribute("type"),"password",
                "This attribute does not have 'password' value");
    }

    @Test
    @Description("")
    public void DisplaysErrorsWhenUserAlreadyExists() {
        navPage.signUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
        signUpPage.enterName().sendKeys("Another User");
        signUpPage.enterImail().sendKeys("admin@admin.com");
        signUpPage.enterPassword().sendKeys("12345");
        signUpPage.confirmPassword().sendKeys("12345");
        signUpPage.signMeUpButton().click();
        messagePopUpPage.waitForPopUpToShowUp();
        Assert.assertEquals(messagePopUpPage.getTextElement(),"E-mail already exists",
                "Error does not contains massage 'E-mail already exists'");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    @Description("")
    public void Signup() {
        navPage.signUpButton().click();
        signUpPage.enterName().sendKeys("Luka Andrejevic");
        signUpPage.enterImail().sendKeys("Luka.Andrejevic@itbootcamp.rs");
        signUpPage.enterPassword().sendKeys("12345");
        signUpPage.confirmPassword().sendKeys("12345");
        signUpPage.signMeUpButton().click();
        messagePopUpPage.waitForVerifyYourAccountPopUp();
        Assert.assertEquals(messagePopUpPage.verifyYourAccountBannerHeader().getText(),
                "IMPORTANT: Verify your account");
        messagePopUpPage.getCloseButton().click();
        navPage.logoutButton().click();
    }

}
