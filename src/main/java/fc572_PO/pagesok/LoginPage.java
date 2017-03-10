package fc572_PO.pagesok;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    WebDriver webDriver;

    @FindBy(id = "field_uname")
    WebElement field_uname;

    @FindBy(id = "field_pwd")
    WebElement field_pwd;

    @FindBy(id = "loginBtn")
    WebElement loginbtn;

    @FindBy(id = "resetBtn")
    WebElement resetbtn;

    @FindBy(id = "demo")
    WebElement textHolder;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void login(String username, String password) {
        field_uname.sendKeys(username);
        field_pwd.sendKeys(password);
        loginbtn.click();
    }

    public boolean verifyLogin() {
        return textHolder.isEnabled() && textHolder.getText().equalsIgnoreCase("You are now logged in into the Matrix");
    }

    public void reset() {
        resetbtn.click();
    }

    public boolean verifyReset() {
        return textHolder.isEnabled() && textHolder.getText().equalsIgnoreCase("");
    }
}