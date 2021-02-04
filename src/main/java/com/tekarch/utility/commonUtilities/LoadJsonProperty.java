package com.tekarch.utility.commonUtilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class LoadJsonProperty {
    static Properties prop = new Properties();
    static FileInputStream fileInp = null;
    Logger log= Logger.getLogger(getClass().getSimpleName());

    public  void loadingJsonFile(String sPath) throws Exception {
        //Load the input from property file. Set(key:Value) & get the runtime properties
       // String sPath = System.getProperty("Resources/Browser.json");
        //String sPath = "C:\Users\vijay\IdeaProjects\Framework_Practice1\Resources\Browser.json";
        FileInputStream fileInp = new FileInputStream(sPath);
        log.info("Log4j Property file Path :" + sPath);
        prop.load(fileInp);
        System.getProperties().putAll(prop);


    }
}
