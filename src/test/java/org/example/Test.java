package org.example;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static WebDriver browser;
    PageObjectsModel start = new PageObjectsModel(browser);

    @Before
    public void before(){
        browser = new ChromeDriver();

    }

    @org.junit.Test

    public void test1(){
        browser.get("https://www.google.com/");
        start.findInGoogle("Калькулятор").pressButton("(")
                .pressButton("1").pressButton("+")
                .pressButton("2").pressButton(")")
                .pressButton("×").pressButton("3")
                .pressButton("−").pressButton("4")
                .pressButton("0").pressButton("÷")
                .pressButton("5").pressButton("=")
                .result("1");

    }

    @org.junit.Test

    public void test2(){
        browser.get("https://www.google.com/");
        start.findInGoogle("Калькулятор").pressButton("6")
                .pressButton("÷").pressButton("0")
                .pressButton("=").result("Infinity");

    }

    @org.junit.Test

    public void test3(){
        browser.get("https://www.google.com/");
        start.findInGoogle("Калькулятор")
                .pressButton("sin").pressButton("=")
                .result("Error");

    }
    @After

    public void after(){
    browser.close();
    }



}
