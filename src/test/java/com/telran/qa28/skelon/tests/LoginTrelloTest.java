package com.telran.qa28.skelon.tests;

import com.telran.qa28.skelon.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTest extends TestBase {
    @BeforeMethod
    public void preConditions(){
        if(app.getSession().isAvatarPresent()){
            app.getSession().logout();
        }
    }

    @Test
    public void loginLogoutTest() throws InterruptedException {
        User user = new User().setEmail("skelon@bk.ru").setPassword("Sand2@14");

        app.getSession().clickOnLogin();
        app.getSession().fillLoginForm(user);
        app.getSession().confirmLogin();
        Assert.assertTrue(app.getSession().isAvatarBoardPresent());
        app.getSession().logout();
        Assert.assertTrue(app.getSession().checkUserLoggedOut());
    }

    @Test
    public void negativeLoginLogoutTestwithoutPassword() throws InterruptedException {
        User user = new User().setEmail("skelon@bk.ru");

        app.getSession().clickOnLogin();
        app.getSession().fillLoginForm(user);
        app.getSession().confirmLogin();
        Assert.assertTrue(app.getSession().isErrorPresent(),"Error is not present");
        //  app.getSession().logout();
        //  Assert.assertTrue(app.getSession().checkUserLoggedOut());
    }
}

