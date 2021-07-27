package com.telran.qa28.skelon;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preConditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresent()) {
            app.getSession().login("skelon@bk.ru", "Sand2@14");
        }
    }

    @Test
    public void boardCreationTest() {
        String boardName = "Board-QA28-" + System.currentTimeMillis();
        app.getBoard().clickOnPlusButton();
        app.getBoard().selectCreateBoard();
        app.getBoard().fillBoardCreation(boardName);
        app.getBoard().confirmBoardCreation();
        app.getBoard().waitForAddListButtonInTheBoard();
        String title = app.getBoard().getTitle();
        Assert.assertEquals(title, boardName);
    }
}

