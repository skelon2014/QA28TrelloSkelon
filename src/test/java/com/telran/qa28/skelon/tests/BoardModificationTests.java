package com.telran.qa28.skelon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase{
    @BeforeMethod
    public void preConditions() throws InterruptedException {
        if (!app.session().isAvatarPresent()) {
            app.session().login("skelon@bk.ru", "Sand2@14");
        }
        if(app.board().isThereABoard()){
            app.board().createBoard();
        }
    }
    @Test
    public void boardNameModificationTest() throws InterruptedException {
        int before = app.board().getBoardsCount();
        app.board().selectFirstBoard();
        Thread.sleep(2000);
        app.board().editBoardName("Edited Board");
        app.board().returnOnHomePage();
        int after = app.board().getBoardsCount();
        Assert.assertEquals(after,before);

    }
}
