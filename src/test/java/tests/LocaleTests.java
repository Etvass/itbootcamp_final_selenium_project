package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 1)
    @Description("Test #1: Set locale to ES")
    public void SetLocaleToES() {
        navPage.choseLanguageButton().click();
        navPage.esLanguage().click();
        Assert.assertEquals(messagePopUpPage.verifyHeader().getText(),"Página de aterrizaje");
    }

    @Test(priority = 2)
    @Description("Test #2: Set locale to EN")
    public void SetLocaleToEN() {
        navPage.choseLanguageButton().click();
        navPage.enLanguage().click();
        Assert.assertEquals(messagePopUpPage.verifyHeader().getText(),"Página de aterrizaje");
    }

    @Test(priority = 3)
    @Description("Test #3: Set locale to CN")
    public void SetLocaleToCN() {
        navPage.choseLanguageButton().click();
        navPage.cnLanguage().click();
        Assert.assertEquals(messagePopUpPage.verifyHeader().getText(),"首页");
    }

    @Test(priority = 4)
    @Description("Test #4: Set locale to FR")
    public void SetLocaleToFR() {
        navPage.choseLanguageButton().click();
        navPage.frLanguage().click();
        Assert.assertEquals(messagePopUpPage.verifyHeader().getText(),"Page d'atterrissage");
    }

}
