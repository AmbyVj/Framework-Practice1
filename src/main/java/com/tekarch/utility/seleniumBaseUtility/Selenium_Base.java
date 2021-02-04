package com.tekarch.utility.seleniumBaseUtility;

import com.tekarch.base.WebDrvrManager;
import com.tekarch.utility.commonUtilities.Set_Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class Selenium_Base  extends Set_Properties {

    WebDrvrManager driverMgr = new WebDrvrManager();
    Logger log = Logger.getLogger(getClass().getSimpleName());
    public WebDriver launchApp() {
        driverMgr.launchApp(sBrowser);
        return driverMgr.driver();

    }

    public void quitApp() {
        driverMgr.quitApp();

    }
    public void goToTkarchURL() {
        driverWeb = driverMgr.driver();
        log.info(driverWeb);
        driverWeb.get("https://qa-tekarch.firebaseapp.com/");
    }


    public  void googleDotCom() {
        driverWeb.get("https://google.com");
    }
    public  void waitExplicitly(int iSeconds, WebElement ele, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, iSeconds);
        wait.ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }


    public static void printListOfWebElements(List<WebElement> li, boolean bPrintSingleLine) throws Exception{
        for(int count = 0 ; count < li.size(); count++)
        {
            if(bPrintSingleLine)
                System.out.print(li.get(count).getText()+"\t");
            else
                System.out.println(li.get(count).getText());
        }
        if(bPrintSingleLine)
            System.out.println();

    }

    public void waitTillDisplayUsingHardWait(String xpath) throws Exception{
        int count = 0;
        boolean bRes_Flag=true;
        while(bRes_Flag)
        {
            try {
                if(count == 10)
                    bRes_Flag = false;
                driverWeb.findElement(By.xpath(xpath)).isDisplayed();
                bRes_Flag = false;
            }
            catch(Exception a) {
                count++;
                Thread.sleep(1000);
            }
        }
    }
    public void webElementClear(WebElement ele) {
        ele.clear();
    }
    public void webElementSendKeys(WebElement ele, String sValue) {
        ele.sendKeys(sValue);
    }
    public void webElementClick(WebElement ele) {
        ele.click();
    }




}
