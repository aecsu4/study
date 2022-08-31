package org.example;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    public static WebDriver browser;
    PageObjectsModel start = new PageObjectsModel();
    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        browser = new ChromeDriver();

    }

    @Test

    public void test1(){
        browser.get("https://www.google.com/");
        start.findInGoogle("Калькулятор");
        start.pressButton("(");
        start.pressButton("1");
        start.pressButton("+");
        start.pressButton("2");
        start.pressButton(")");
        start.pressButton("×");
        start.pressButton("3");
        start.pressButton("−");
        start.pressButton("4");
        start.pressButton("0");
        start.pressButton("÷");
        start.pressButton("5");
        start.pressButton("=");
        start.result("1");

    }

    @Test

    public void test2(){
        browser.get("https://www.google.com/");
        start.findInGoogle("Калькулятор");

        start.pressButton("6");
        start.pressButton("÷");
        start.pressButton("0");
        start.pressButton("=");
        start.result("Infinity");
    }

    @Test

    public void test3(){
        browser.get("https://www.google.com/");
        start.findInGoogle("Калькулятор");

        start.pressButton("sin");
        start.pressButton("=");
        start.result("Error");
    }
    @After

    public void after(){
    browser.close();
    }



}
