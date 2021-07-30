package com.telran.qa28.skelon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase{
    @BeforeMethod
    public void preConditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresent()) {
            app.getSession().login("skelon@bk.ru", "Sand2@14");
        }
        if(app.getBoard().isThereABoard()){
            app.getBoard().createBoard();
        }
    }
    @Test
    public void boardNameModificationTest(){
        int before = app.getBoard().getBoardsCount();
        app.getBoard().selectFirstBoard();
        app.getBoard().editBoardName("Edited Board");
        app.getBoard().returnOnHomePage();
        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after,before);

    }
}
