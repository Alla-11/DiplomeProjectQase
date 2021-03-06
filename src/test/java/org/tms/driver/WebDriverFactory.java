package org.tms.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    public WebDriverFactory(){
    }

    public static WebDriver getWebDriver(){
        WebDriver driver = null;
        switch (System.getProperty("browser")) {
            case "firefox":{
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;}
            case "edge":{
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;}
            case "opera":{
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;}
            default:{
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);}
        }
        driver.manage().window().maximize();
        return driver;
    }
}
