package org.example;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
public class PageObjectsModel {

    PageObjectsModel(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        PageFactory.initElements(browser, this);
    }
    public PageObjectsModel pressButton(String nameOfButton) {
        test.browser.findElement(By.xpath("//*[contains(@class, 'XRsWPe') and text() = '"+ nameOfButton + "'] ")).click();
        return this;
    }

    public PageObjectsModel findInGoogle(String text) {
        test.browser.findElement(By.xpath("//input[contains(@title, 'Поиск')]")).sendKeys(text, Keys.ENTER);
        return this;
    }
    public PageObjectsModel result(String excepted) {
        String actual = test.browser.findElement(By.xpath("//*[contains(@class, 'qv3Wpe') and text()]")).getText();
        Assert.assertEquals("Test failed dolbojeb ", excepted, actual);
        return this;
    }





}
