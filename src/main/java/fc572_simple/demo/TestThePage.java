package fc572_simple.demo;


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

public class TestThePage
{
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
    }
    @After
    public void destroyTest()
    {
        webDriver.close();
    }

    @Test
    public void thisIsATest()
    {
        WebElement findMeById = webDriver.findElement(By.id("fieldId"));
        WebElement findMeByName = webDriver.findElement(By.name("fieldName"));
        WebElement findMeByClassName = webDriver.findElement(By.className("fieldClass"));
        WebElement findMeByLinkText = webDriver.findElement(By.linkText("FullLinkText"));
        WebElement findMeByPartialLinkText = webDriver.findElement(By.partialLinkText("PartialLin"));
        WebElement findMeByCssSelector = webDriver.findElement(By.cssSelector("#maincontainer li:first-child"));
        WebElement findMeByCssSelector2 = webDriver.findElement(By.cssSelector("#maincontainer ul:nth-child(2) > li:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > ol:nth-child(1) > li:nth-child(2)"));
        WebElement findMeByCssSelector3 = webDriver.findElement(By.cssSelector("#maincontainer ul:nth-child(2) > li:nth-child(2) > ul:nth-child(1) > li:nth-child(2)"));
        WebElement findMeByXPath = webDriver.findElement(By.xpath("//input[@type='checkbox' and @value='HappyTesting']"));
        WebElement findMeByXPath2 = webDriver.findElement(By.xpath("//input[@name='pickMe' and @value='HappyTesting']"));

        findMeById.sendKeys("Found By.id");
        findMeByName.sendKeys("Found By.Name");
        findMeByClassName.click();
        assertTrue(findMeByLinkText.getText().equalsIgnoreCase("FullLinkText"));
        assertTrue(findMeByPartialLinkText.getText().equalsIgnoreCase("PartialLinkText"));
        assertTrue(findMeByCssSelector.getText().contains("Item 1"));
        assertTrue(findMeByCssSelector2.getText().contains("Sub Sub Item 1.2"));
        assertTrue(findMeByCssSelector3.getText().contains("Sub Item 2.3"));
        findMeByXPath.click();
        findMeByXPath2.click();
    }
}
