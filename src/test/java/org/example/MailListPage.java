package org.example;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailListPage {
    private final WebDriver browser;
    @FindBy(css = "span[class='Counters-m__total--WD+FS qa-LeftColumn-CountersTotal']")
    public WebElement numberMails;
    @FindBy(css = "a[href='#compose']")
    public WebElement writeNewMailButton;
    @FindBy(css = "div[title='Кому']")
    public WebElement adressInput;
    @FindBy(css = "div[class='ContactsSuggestItemDesktop-Email']")
    public WebElement myAdressString;
    @FindBy(css = "input[id='compose-field-subject-4']")
    public WebElement themeMailInput;
    @FindBy(css = "[role = 'textbox']")
    public WebElement mailContainerInput;
    @FindBy(css = "button[aria-disabled]")
    public WebElement sendMailButton;
    @FindBy(css = "[class='control link link_theme_normal ComposeDoneScreen-Link']")
    public WebElement returnMainPage;
    public String oldMailsNumberStr;
    public String expectedMailNumber;
    public String currentMailNumber;

    public MailListPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public MailListPage sendMail(String themeOfMail, String oldMailsNumberStr){
        writeNewMailButton.click();
        adressInput.click();
        myAdressString.click();
        themeMailInput.sendKeys(themeOfMail, Keys.ENTER);
        mailContainerInput.sendKeys("Найдено "+oldMailsNumberStr+" писем\\ьма", Keys.ENTER);
        sendMailButton.click();
        returnMainPage.click();
        browser.navigate().refresh();
        return this;
    }

    public MailListPage actualMailCheck() {
        String oldMailsNumberStr = numberMails.getText();
        String expectedMailsNumber = Integer.toString(Integer.parseInt(oldMailsNumberStr)+1);
        String currentMailNumber = numberMails.getText();
        this.oldMailsNumberStr = oldMailsNumberStr;
        this.expectedMailNumber = expectedMailsNumber;
        this.currentMailNumber = currentMailNumber;
        return this;
    }
}
