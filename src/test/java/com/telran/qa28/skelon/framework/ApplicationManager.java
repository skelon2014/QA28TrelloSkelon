package com.telran.qa28.skelon.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    BoardHelper board;
    SessionHelper session;
    ListHelper list;
    CardHelper card;

    //=======================================================
    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openSite("https://trello.com/");
        board = new BoardHelper(wd);
        session = new SessionHelper(wd);
        list = new ListHelper(wd);
        card = new CardHelper(wd);
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
//===============================================================
    public void stop() {
        wd.quit();
    }
}
