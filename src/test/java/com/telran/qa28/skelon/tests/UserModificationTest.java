package com.telran.qa28.skelon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserModificationTest extends TestBase {
    @BeforeMethod
    public void preConditions() throws InterruptedException {
        if (!app.session().isAvatarPresent()) {
            app.session().login("skelon@bk.ru", "Sand2@14");
        }
        if (!app.board().isOnTheBoardsPage()) {
            app.board().returnOnHomePage();
        }
    }
//open new page/window
    @Test
    public void test() throws InterruptedException {
        app.session().openTabAndSwitchToIt();
    }

    //open in drop window

//=============================================
    @Test
    public void testChangeUserAvatar() throws InterruptedException {
        app.session().clickOnAvatar();
        app.session().openUserProfile();
        app.session().goToAtlassinAccount();
        Thread.sleep(5000);
        String url = app.getUrl();
        Assert.assertEquals(url, "https://id.atlassian.com/manage-profile/profile-and-visibility"
                , "Wrong URL" + app.getUrl());
        app.atlassian().initChangePhoto();
        app.atlassian().uploadPhoto();


        app.session().returnToTrelloFromAtlassian();
        String currUrl = app.getUrl();
        Assert.assertTrue(currUrl.contains("https://trello.com/"), "Current URL "+app.getUrl());


    }
}
