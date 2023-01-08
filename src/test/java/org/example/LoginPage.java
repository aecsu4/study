package org.example;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver browser;
    @FindBy(className = "PSHeader-NoLoginButton")
    private WebElement entranceToMailButton;
    @FindBy(className = "Textinput-Control")
    private WebElement loginInput;
    @FindBy(css = "[name='passwd']")
    private WebElement passInput;
    @FindBy(className = "Button2_view_default")
    private WebElement loginWithMailSelector;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public LoginPage loginToYandex(String login, String pass){
        entranceToMailButton.click();
        loginWithMailSelector.click();
        loginInput.sendKeys(login, Keys.ENTER);
        passInput.sendKeys(pass, Keys.ENTER);
        return this;
    }
}
