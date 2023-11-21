package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/ ";
    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // find the username element
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Admin");
        // find the passwordfield and type the password to it
        driver.findElement(By.name("password")).sendKeys("admin123");
        // find the login button and click to submit
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        String expectedErrorMessage = "Dashboard";
        // find the errormessage and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals("Dashboard", expectedErrorMessage,actualErrorMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
