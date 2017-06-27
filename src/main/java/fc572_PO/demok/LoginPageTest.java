
package fc572_PO.demok;


import fc572_PO.pagesok.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LoginPageTest {

    private WebDriver webDriver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "browser/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://fc572.github.io/testexercise/loginPage.html");
        webDriver.manage().window().maximize();
        WebElement waitForMe = (new WebDriverWait(webDriver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("loginBtn")));
        loginPage = new LoginPage(webDriver);
    }

    @Test
    public void checkLogin(){
        loginPage.login("Neo", "redpill");
        assertTrue(loginPage.verifyLogin());
    }

    @Test
    public void checkResetButton(){
        checkLogin();
        loginPage.reset();
        assertTrue(loginPage.verifyReset());
    }

    @After
    public void tearDown(){
        webDriver.close();
        webDriver.quit();
    }
}
