package org.example;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailListPage {
    @FindBy(className = "qa-LeftColumn-CountersTotal")
    public WebElement numberMails;
    @FindBy(css = "a[href='#compose']")
    public WebElement writeNewMailButton;
    @FindBy(css = "div[title='Кому']")
    public WebElement adressInput;
    @FindBy(className = "ContactsSuggestItemDesktop")
    public WebElement myAdressString;
    @FindBy(className = "ComposeSubject-TextField")
    public WebElement themeMailInput;
    @FindBy(css = "[role = 'textbox']")
    public WebElement mailContainerInput;
    @FindBy(css = "button[aria-disabled]")
    public WebElement sendMailButton;
    @FindBy(className = "ComposeDoneScreen-Link")
    public WebElement returnMainPage;

    public MailListPage(WebDriver browser) {
        PageFactory.initElements(browser, this);
    }

    public MailListPage sendMail(String theme, String text){
        writeNewMailButton.click();
        adressInput.click();
        myAdressString.click();
        themeMailInput.sendKeys(theme, Keys.ENTER);
        mailContainerInput.sendKeys(text, Keys.ENTER);
        sendMailButton.click();
        returnMainPage.click();
        return this;
    }

    public int mailNumberGet() {
        return Integer.parseInt(numberMails.getText());
    }
}
