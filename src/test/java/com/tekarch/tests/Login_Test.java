package com.tekarch.tests;

import com.tekarch.Pages.Login_Page;
import com.tekarch.utility.commonUtilities.Set_Properties;
import com.tekarch.utility.seleniumBaseUtility.Selenium_Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_Test extends Set_Properties {
    Login_Page logPage;

    @BeforeTest
    public void settingDependecy() {
        logPage = new Login_Page(driverWeb);
        selBase.goToTkarchURL();
    }
    @Test
    public void loginToTekarchWebAutomationPortal() {
        logPage.tekarchLogin();
    }
}

