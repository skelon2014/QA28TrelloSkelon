package com.telran.qa28.skelon.tests;

import com.telran.qa28.skelon.framework.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        // Capabilities caps = new DesiredCapabilities();
        app.init();
    }

    @AfterSuite//(enabled = false)
    public void tearDown() throws InterruptedException {
        app.board().clearBoardsList();
        app.stop();
    }


}
