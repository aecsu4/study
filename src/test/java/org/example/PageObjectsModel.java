package org.example;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PageObjectsModel {
    private final WebDriver browser;
    public String expectedMailsNumber;
    //Записываю xpath и css селекторы в строку
    String numberOfMails = "//*[@class='Counters-m__total--WD+FS qa-LeftColumn-CountersTotal']";
    String entranceToMailButton = "//*[@type = 'button' and @weight = '500']";
    String loginInput = "//*[@id='passp-field-login']";
    String passInput = "//*[@id='passp-field-passwd']";
    String writeNewMailButton = "//*[@role= 'button' and @href = '#compose']";
    String adressInput = "//*[@title= 'Кому']";
    String myAdressString = "//*[@class = 'ContactsSuggestItemDesktop-Email']";
    String themeOfMailInput = "//*[@id='compose-field-subject-4']";
    String mailContainerInput = "[role = 'textbox']";
    String sendMailButton = "//*[@type = 'button' and @aria-disabled='false']";
    String returnToMainPage = "//*[text()='Вернуться во \"Входящие\"']";
    String loginWithMailSelector = "//*[@type = 'button'][1]";

    public PageObjectsModel(WebDriver browser) {
        this.browser = browser;
    }

    public PageObjectsModel loginToYandex(String login,String pass){
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        browser.findElement(By.xpath(entranceToMailButton)).click();
        browser.findElement(By.xpath(loginWithMailSelector)).click();
        browser.findElement(By.xpath(loginInput)).sendKeys(login, Keys.ENTER);
        browser.findElement(By.xpath(passInput)).sendKeys(pass, Keys.ENTER);
        return this;
    }

    public PageObjectsModel sendMail(String themeOfMail){
        //Парсинг общего числа писем в папке входящие
        String oldMailsNumberStr = browser.findElement(By.xpath(numberOfMails)).getText();
        String expectedMailsNumber = Integer.toString(Integer.parseInt(oldMailsNumberStr)+1);
        this.expectedMailsNumber = expectedMailsNumber;
        //Нажатие на кнопку Написать
        browser.findElement(By.xpath(writeNewMailButton)).click();
        //Нажатие на страницу адресации
        browser.findElement(By.xpath(adressInput)).click();
        //Выбор строчки "Себе"
        browser.findElement(By.xpath(myAdressString)).click();
        //Ввод темы письма
        browser.findElement(By.xpath(themeOfMailInput)).sendKeys(themeOfMail, Keys.ENTER);
        new WebDriverWait(browser, Duration.ofSeconds(5));
        //Ввод содержания письма
        browser.findElement(By.cssSelector(mailContainerInput)).sendKeys("Найдено "+oldMailsNumberStr+" писем\\ьма", Keys.ENTER);
        browser.findElement(By.xpath(sendMailButton)).click();
        browser.findElement(By.xpath(returnToMainPage)).click();
        return this;
    }

    public void assertResult() {
        browser.navigate().refresh();
        String actual = browser.findElement(By.xpath("//*[@id='js-apps-container']/div[2]/div[7]/div/div[3]/div/nav/div[3]/div/div[1]/div/div[1]/div[1]/div[1]/div/div/span/span[2]")).getText();
        Assert.assertEquals("Test failed dolbojeb ", actual, expectedMailsNumber);
    }
}
