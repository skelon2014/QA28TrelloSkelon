package com.telran.qa28.skelon.tests;

import com.google.common.io.Files;
import com.telran.qa28.skelon.framework.ApplicationManager;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    public static class MyListener extends AbstractWebDriverEventListener {
        Logger logger = LoggerFactory.getLogger(MyListener.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
               super.beforeFindBy(by, element, driver);
            logger.info("Start search element " + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
               super.afterFindBy(by, element, driver);
            logger.info("Element " + by + " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
               super.onException(throwable, driver);
            logger.error("ERROR!!! TEST FAILED!!!\n", throwable);

            long l = System.currentTimeMillis() / 1000000;
            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String pathName = "ScreenShots/screen-" + l + ".png";
            File screenshot = new File(pathName);
            try {
                Files.copy(tmp, screenshot);
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.error("screenshot - " + pathName);
        }
    }

    @BeforeSuite
    public void setUp() throws IOException, InterruptedException {
        // Capabilities caps = new DesiredCapabilities();
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        app.board().clearBoardsList();
        app.stop();
    }

    @BeforeMethod
    public void startLogger(Method m, Object[] parameter) {

        logger.info("Test " + m.getName() + " started with parametres - " + Arrays.asList(parameter));
    }

    @AfterMethod
    public void stopLogger(Method m) {
        logger.info("Test " + m.getName() + " finished");
    }
}
