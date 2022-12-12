package org.example;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver browser;
    @FindBy(css = "button[autocomplete]")
    private WebElement entranceToMailButton;
    @FindBy(css = "input[id='passp-field-login']")
    private WebElement loginInput;
    @FindBy(css = "input[name='passwd']")
    private WebElement passInput;
    @FindBy(css = "button[data-t='button:default']")
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
