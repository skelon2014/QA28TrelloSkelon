package com.telran.qa28.skelon.tests;

import com.telran.qa28.skelon.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preConditions() throws InterruptedException {
        if (!app.session().isAvatarPresent()) {
            app.session().login("skelon@bk.ru", "Sand2@14");
        }
    }

    @Test
    public void boardCreationTest() throws InterruptedException {

        String boardName = "Board-QA28-" + System.currentTimeMillis() / 3600000;
        Thread.sleep(5000);
        int before = app.board().getBoardsCount();
      //  app.getBoard().createBoard();

       app.board().clickOnPlusButton();
       app.board().selectCreateBoard();
       app.board().fillBoardCreation(new Board().withBoardName(boardName));
       app.board().confirmBoardCreation();
        app.board().waitForAddListButtonInTheBoard();
        String title = app.board().getTitle();
        Assert.assertEquals(title, boardName);

        app.board().returnOnHomePage();
        Thread.sleep(2000);
        int after = app.board().getBoardsCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("Boards - " + after);
    }
}

