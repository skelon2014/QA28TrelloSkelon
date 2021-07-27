package com.telran.qa28.skelon;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        // Capabilities caps = new DesiredCapabilities();
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }


}
