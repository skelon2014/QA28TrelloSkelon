package com.telran.qa28.skelon;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preConditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresent()) {
            app.getSession().login("skelon@bk.ru", "Sand2@14");
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        Thread.sleep(4000);
        int boardCount = app.getBoard().getBoardsCount();
        System.out.println("boardCount = " + boardCount);
          while(boardCount > 1) {
        app.getBoard().selectFirstBoard();
        app.getBoard().openMenu();
        app.getBoard().deleteBoard();
        app.getBoard().returnOnHomePage();
        boardCount = app.getBoard().getBoardsCount();
          }
        System.out.println("boardCount = " + boardCount);
        // Assert.
    }

}
