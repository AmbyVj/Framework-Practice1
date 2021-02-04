package com.tekarch.utility.commonUtilities;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class Log4jProperty {
    static Properties props = new Properties();
    static FileInputStream fis = null;

    Logger log= Logger.getLogger(getClass().getSimpleName());

    public void loadLog4jProperty(String PropertiesFilePath) throws Exception {
        log.info("Log4j Property file Path :" + PropertiesFilePath);
        fis = new FileInputStream(PropertiesFilePath);
        props.load(fis);
        PropertyConfigurator.configure(props);
    }
}
