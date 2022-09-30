package org.example;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCalculator {
    public static WebDriver browser;
    public static PageObjectsModel start;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        browser = new ChromeDriver();
        start = new PageObjectsModel(browser);

    }

    @Test

    public void test1(){
        browser.get("https://www.google.com/");
        start.findInGooglePage("Калькулятор").pressButton("(")
                .pressButton("1").pressButton("+")
                .pressButton("2").pressButton(")")
                .pressButton("×").pressButton("3")
                .pressButton("−").pressButton("4")
                .pressButton("0").pressButton("÷")
                .pressButton("5").pressButton("=")
                .assertResult("1");
    }

    @Test

    public void test2(){
        browser.get("https://www.google.com/");
        start.findInGooglePage("Калькулятор").pressButton("6")
                .pressButton("÷").pressButton("0")
                .pressButton("=").assertResult("Infinity");
    }

    @Test

    public void test3(){
        browser.get("https://www.google.com/");
        start.findInGooglePage("Калькулятор")
                .pressButton("sin").pressButton("=")
                .assertResult("Error");
    }
    @After

    public void after(){
    browser.close();
    }



}
