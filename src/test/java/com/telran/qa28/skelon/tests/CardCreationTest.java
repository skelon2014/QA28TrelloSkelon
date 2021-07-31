package com.telran.qa28.skelon.tests;

import com.telran.qa28.skelon.model.Card;
import com.telran.qa28.skelon.model.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CardCreationTest extends TestBase {
    @BeforeMethod
    public void preConditions() throws InterruptedException {
        if (!app.session().isAvatarPresent()) {
            app.session().login("skelon@bk.ru", "Sand2@14");
        }
      /*  if(!app.board().isThereABoard()){
            app.board().createBoard();
        }*/
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

}
