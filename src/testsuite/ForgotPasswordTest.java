package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/ ";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        // find the username field
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Admin");
        // find the forgot password button and click
        driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
        String expectedErrorMessage = "Reset Password";
        // find the errormessage and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")).getText();
        Assert.assertEquals("Reset Password", expectedErrorMessage,actualErrorMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
