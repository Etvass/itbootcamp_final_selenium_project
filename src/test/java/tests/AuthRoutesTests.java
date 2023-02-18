package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{

    @Test
    @Description("")
    public void ForbidsVisitsToHomeUrlIfNotAuthenticated() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    @Description("")
    public void ForbidsvisitstoProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl+"/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"));
    }

    @Test
    @Description("")
    public void ForbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl+"/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    @Description("")
    public void ForbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl+"/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}
