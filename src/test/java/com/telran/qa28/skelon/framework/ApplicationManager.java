package com.telran.qa28.skelon.framework;

import com.telran.qa28.skelon.tests.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;
    Properties properties;
    // WebDriver wd;
    BoardHelper board;
    SessionHelper session;
    ListHelper list;
    CardHelper card;
    String browser;
    AtlassianHelper atlassian;

    public ApplicationManager(String browser) {

        this.browser = browser;
        properties = new Properties();
    }

    //=======================================================
    public void init() throws IOException, InterruptedException {
        String target = System.getProperty("target", "default");
        properties.load
                (new FileReader(new File(String.format("src/test/resources/serg.properties", target))));
        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }//etc....

        wd.register(new TestBase.MyListener());
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //openSite("https://trello.com");
        openSite(properties.getProperty("web.baseURL"));

        board = new BoardHelper(wd);
       // session = new SessionHelper(wd);
        session = new SessionHelper(wd, properties);
        list = new ListHelper(wd);
        card = new CardHelper(wd);
        atlassian = new AtlassianHelper(wd);
      //  session.login(properties.getProperty("web.user"), properties.getProperty("web.password"));
    }

    //==================================================
    public void openSite(String url) {
        wd.get(url);
    }

    public BoardHelper board() {
        return board;
    }

    public SessionHelper session() {
        return session;
    }

    public ListHelper list() {
        return list;
    }

    public CardHelper card() {
        return card;
    }

    public AtlassianHelper atlassian() {
        return atlassian;
    }

    //===============================================================
    public void stop() {
        wd.quit();
    }

    public String getUrl() {
        return wd.getCurrentUrl();
    }
}
