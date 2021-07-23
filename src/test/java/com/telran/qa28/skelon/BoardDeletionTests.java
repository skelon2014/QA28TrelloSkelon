package com.telran.qa28.skelon;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeClass
    public void preConditions() throws InterruptedException {
        if (!isAvatarPresent()) {
            login("skelon@bk.ru", "Sand2@14");
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        Thread.sleep(5000);
        int boardCount = getBoardsCount();
        //  while(boardCount > 1) {
        selectFirstBoard();
        openMenu();
        deleteBoard();
        returnOnHomePage();
        boardCount--;
        //  }
        System.out.println("boardCount = " + boardCount);
        // Assert.
    }

    private int getBoardsCount() {
        return wd.findElements(By.xpath
                ("//*[contains(@class, 'boards-page-board-section-header-icon-default-image')]/../../../..")).size() - 1;
    }

    private void selectFirstBoard() {
        click(By.xpath("//*[contains(@class, 'boards-page-board-section-header-icon-default-image')]/../../../..//li"));
    }

    private void openMenu() {
        click(By.xpath("//span[.='Show menu']"));
    }

    private void deleteBoard() {
        if (!isElementDisplayed(By.cssSelector(".js-open-more"))) {
            click(By.cssSelector(".icon-back"));
        }
        click(By.cssSelector(".js-open-more"));

        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector(".js-delete"));
        click(By.cssSelector(".js-confirm"));
    }

    private void returnOnHomePage() {
        waitForElement(By.cssSelector("[aria-label='HouseIcon']"), 20);
        click(By.cssSelector("[aria-label='HouseIcon']"));
    }


}
