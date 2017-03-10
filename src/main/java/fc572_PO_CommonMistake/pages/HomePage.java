package fc572_PO_CommonMistake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    public WebElement findMeById;
    public WebElement findMeByName;
    public WebElement findMeByClassName;
    public WebElement findMeByLinkText;
    public WebElement findMeByPartialLinkText;
    public WebElement findMeByCssSelector;
    public WebElement findMeByCssSelector2;
    public WebElement findMeByCssSelector3;
    public WebElement findMeByXPath;
    public WebElement findMeByXPath2;
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

        findMeById = webDriver.findElement(By.id("fieldId"));
        findMeByName = webDriver.findElement(By.name("fieldName"));
        findMeByClassName = webDriver.findElement(By.className("fieldClass"));
        findMeByLinkText = webDriver.findElement(By.linkText("FullLinkText"));
        findMeByPartialLinkText = webDriver.findElement(By.partialLinkText("PartialLin"));
        findMeByCssSelector = webDriver.findElement(By.cssSelector("#maincontainer li:first-child"));
        findMeByCssSelector2 = webDriver.findElement(By.cssSelector("#maincontainer ul:nth-child(2) > li:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > ol:nth-child(1) > li:nth-child(2)"));
        findMeByCssSelector3 = webDriver.findElement(By.cssSelector("#maincontainer ul:nth-child(2) > li:nth-child(2) > ul:nth-child(1) > li:nth-child(2)"));
        findMeByXPath = webDriver.findElement(By.xpath("//input[@type='checkbox' and @value='HappyTesting']"));
        findMeByXPath2 = webDriver.findElement(By.xpath("//input[@name='pickMe' and @value='HappyTesting']"));
    }
}
