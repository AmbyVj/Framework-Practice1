package com.tekarch.utility.commonUtilities;

import com.jayway.jsonpath.JsonPath;
import com.tekarch.utility.seleniumBaseUtility.Selenium_Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Set_Properties {
    public static String sConfig;
    public static String sBrowser;
    public static String sAutomation;

    public WebDriver driverWeb;
    public static Selenium_Base selBase = new Selenium_Base();
    public static Log4jProperty logLoad =new Log4jProperty();
    public static LoadJsonProperty jsonLoad = new LoadJsonProperty();
    Logger log = Logger.getLogger(getClass().getSimpleName());

    @BeforeSuite
    public void setProperty() throws Exception {

        logLoad.loadLog4jProperty("C:\\Users\\vijay\\IdeaProjects\\Framework_Practice1\\Resources\\Log4j.properties");
        String jsonPath ="C:\\Users\\vijay\\IdeaProjects\\Framework_Practice1\\Resources\\Browser.json";
        jsonLoad.loadingJsonFile(jsonPath);
        sConfig = readfileReturnInString(jsonPath);

        sAutomation = JsonPath.read(sConfig,"automation");
        if(sAutomation.toLowerCase().equals("web"))
        {
            sBrowser = JsonPath.read(sConfig,"browser");
            driverWeb = selBase.launchApp();

            log.info(driverWeb);
            log.info("All properties are loaded & used");
        }
    }

    public static String readfileReturnInString(String sPathOfJson) throws Exception {
        byte[] encoded = Files.readAllBytes(Paths.get(sPathOfJson));
        return new String(encoded, StandardCharsets.UTF_8);

    }
    }
