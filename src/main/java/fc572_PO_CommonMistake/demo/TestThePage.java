package fc572_PO_CommonMistake.demo;


import fc572_PO_CommonMistake.pages.HomePage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class TestThePage
{
    private HomePage homePage;

    private WebDriver webDriver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "browser/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://fc572.github.io/testexercise/");
        webDriver.manage().window().maximize();
        WebElement waitForMe = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("fieldId")));
        homePage = new HomePage(webDriver);
    }

    @Test
    public void thisIsATest()
    {
        WebElement findMeById = webDriver.findElement(By.id("fieldId"));
        assertTrue(findMeById != null);
        webDriver.close();
    }

    @Test
    public void thisIsATest2()
    {
        homePage.findMeById.sendKeys("Found By.id");
        homePage.findMeByName.sendKeys("Found By.Name");
        homePage.findMeByClassName.click();
        assertTrue(homePage.findMeByLinkText.getText().equalsIgnoreCase("FullLinkText"));
        assertTrue(homePage.findMeByPartialLinkText.getText().equalsIgnoreCase("PartialLinkText"));
        assertTrue(homePage.findMeByCssSelector.getText().contains("Item 1"));
        assertTrue(homePage.findMeByCssSelector2.getText().contains("Sub Sub Item 1.2"));
        assertTrue(homePage.findMeByCssSelector3.getText().contains("Sub Item 2.3"));
        homePage.findMeByXPath.click();
        homePage.findMeByXPath2.click();

    }
}
