package com.telran.qa28.skelon.tests;

import org.testng.Assert;
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
        int before = app.getBoard().getBoardsCount();

        app.getBoard().selectFirstBoard();
        app.getBoard().openMenu();
        app.getBoard().deleteBoard();
        app.getBoard().returnOnHomePage();
        int after = app.getBoard().getBoardsCount();

        Assert.assertEquals(after, before - 1);
    }
}
