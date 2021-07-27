package com.telran.qa28.skelon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTrelloTest extends TestBase {
    @Test
    public void loginLogoutTest() throws InterruptedException {
        app.getSession().clickOnLogin();
        app.getSession().fillLoginForm("skelon@bk.ru", "Sand2@14");
        app.getSession().confirmLogin();
        Assert.assertTrue(app.getSession().isAvatarBoardPresent());
        app.getSession().logout();
        Assert.assertTrue(app.getSession().checkUserLoggedOut());
    }
}

