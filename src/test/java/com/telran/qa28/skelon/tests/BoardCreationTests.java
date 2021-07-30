package com.telran.qa28.skelon.tests;

import com.telran.qa28.skelon.model.Board;
import org.testng.Assert;
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
    public void boardCreationTest() throws InterruptedException {

        String boardName = "Board-QA28-" + System.currentTimeMillis() / 3600000;
        Thread.sleep(5000);
        int before = app.getBoard().getBoardsCount();
      //  app.getBoard().createBoard();

       app.getBoard().clickOnPlusButton();
       app.getBoard().selectCreateBoard();
       app.getBoard().fillBoardCreation(new Board().setBoardName(boardName));
       app.getBoard().confirmBoardCreation();
        app.getBoard().waitForAddListButtonInTheBoard();
        String title = app.getBoard().getTitle();
        Assert.assertEquals(title, boardName);

        app.getBoard().returnOnHomePage();
        Thread.sleep(2000);
        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }
}

