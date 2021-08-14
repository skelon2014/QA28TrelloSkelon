package com.telran.qa28.skelon.tests;

import com.telran.qa28.skelon.model.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListCreationTest extends TestBase {

    @BeforeMethod
    public void preConditions() throws InterruptedException {
        if (!app.session().isAvatarPresent()) {
            app.session().login("skelon@bk.ru", "Sand2@14");
        }
        if (!app.board().isOnTheBoardsPage()) {
            app.board().returnOnHomePage();
        }
        Thread.sleep(3000);
        if (!app.board().isThereABoard()) {
            app.board().createBoard();
        }
    }

    @Test
    public void testListCreation() {
        app.board().selectFirstBoard();
        app.list().addNewList();
        app.list().typeName(new List().withName("AutoTest"));
        app.list().saveEdit();
    }
}
