package com.telran.qa28.skelon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preConditions() throws InterruptedException {
        if (!app.session().isAvatarPresent()) {
            app.session().login("skelon@bk.ru", "Sand2@14");
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        Thread.sleep(4000);
        int before = app.board().getBoardsCount();

        app.board().selectFirstBoard();
        app.board().openMenu();
        app.board().deleteBoard();
        app.board().returnOnHomePage();
        int after = app.board().getBoardsCount();

        Assert.assertEquals(after, before - 1);
    }
}
