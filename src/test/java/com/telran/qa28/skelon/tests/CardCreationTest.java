package com.telran.qa28.skelon.tests;

import com.telran.qa28.skelon.model.Card;
import com.telran.qa28.skelon.model.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class CardCreationTest extends TestBase {


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
    public void testCardCreation() {
        app.board().selectFirstBoard();

        if (!app.list().isThereAList()) {
            app.list().addNewList();
            app.list().typeName(new List().withName("AutoTest"));
            app.list().saveEdit();
        }

        app.card().addNew();
        app.card().fillForm(new Card().withName("withLable").withColor("purple"));
        app.card().confirmCreation();

        app.card().fillForm(new Card().withName("withoutLable"));
        app.card().confirmCreation();


    }
    //=======================================================
    @DataProvider
    public Iterator<Object[]> validCards() {
        java.util.List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"a","red"});
        list.add(new Object[]{"123456","green"});

        return list.iterator();
    }
    @Test(dataProvider =  "validCards")
    public void testCardCreationDP(String name, String color) {
        app.board().selectFirstBoard();

        if (!app.list().isThereAList()) {
            app.list().addNewList();
            app.list().typeName(new List().withName("AutoTest"));
            app.list().saveEdit();
        }

        app.card().addNew();
        app.card().fillForm(new Card().withName(name).withColor(color));
        app.card().confirmCreation();

    }
}
