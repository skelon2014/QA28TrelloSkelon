package com.telran.qa28.skelon.tests;

import com.telran.qa28.skelon.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTest extends TestBase {
    @BeforeMethod
    public void preConditions(){
        if(app.session().isAvatarPresent()){
            app.session().logout();
        }
    }

    @Test
    public void loginLogoutTest() throws InterruptedException {
        User user = new User().withEmail("skelon@bk.ru").withPassword("Sand2@14");

        app.session().clickOnLogin();
        app.session().fillLoginForm(user);
        app.session().confirmLogin();
        Assert.assertTrue(app.session().isAvatarBoardPresent());
        app.session().logout();
        Assert.assertTrue(app.session().checkUserLoggedOut());
    }

    @Test
    public void negativeLoginLogoutTestwithoutPassword() throws InterruptedException {
        User user = new User().withEmail("skelon@bk.ru");

        app.session().clickOnLogin();
        app.session().fillLoginForm(user);
        app.session().confirmLogin();
        Assert.assertTrue(app.session().isErrorPresent(),"Error is not present");
        //  app.getSession().logout();
        //  Assert.assertTrue(app.getSession().checkUserLoggedOut());
    }
}

