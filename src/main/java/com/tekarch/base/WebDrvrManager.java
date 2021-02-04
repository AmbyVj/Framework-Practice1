package com.tekarch.base;

import com.tekarch.driverInterfaces.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Locale;


public class WebDrvrManager implements IDriverManager, IWebDriver {

    public WebDriver driver;
    @Override
    public void launchApp(String sBrowserType) {
        if (sBrowserType.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (sBrowserType.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
    }

    @Override
    public void quitApp() {
            this.driver.quit();
    }

    @Override
    public WebDriver driver() {
        return this.driver;
    }


}
