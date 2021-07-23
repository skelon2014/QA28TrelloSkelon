package com.telran.qa28.skelon;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeClass
    public void preConditions() throws InterruptedException {
        if (!isAvatarPresent()) {
            login("skelon@bk.ru", "Sand2@14");
        }
    }

    @Test
    public void boardCreationTest() {
        String boardName = "Board-QA28-" + System.currentTimeMillis();
        clickOnPlusButton();
        selectCreateBoard();
        fillBoardCreation(boardName);
        confirmBoardCreation();
        waitForAddListButtonInTheBoard();
        String title = getTitle();
        Assert.assertEquals(title, boardName);
    }
}

