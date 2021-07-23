package com.telran.qa28.skelon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTrelloTest extends TestBase {
    @Test
    public void loginLogoutTest() throws InterruptedException {
        clickOnLogin();
        fillLoginForm("skelon@bk.ru", "Sand2@14");
        confirmLogin();
        Assert.assertTrue(isAvatarBoardPresent());
        logout();
        Assert.assertTrue(checkUserLoggedOut());
    }
}

