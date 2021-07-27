package com.telran.qa28.skelon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void fillBoardCreation(String boardName) {
        type(By.xpath("//*[@data-test-id='create-board-title-input']"), boardName);
    }

    public void selectCreateBoard() {
        click(By.xpath("//*[@data-test-id='header-create-board-button']"));
    }

    public void confirmBoardCreation() {
        click(By.xpath("//*[@data-test-id='create-board-submit-button']"));
    }

    public String getTitle() {
        return wd.findElement(By.xpath("//h1")).getText();
    }

    public void waitForAddListButtonInTheBoard() {
        waitForElement(By.cssSelector(".open-add-list"), 15);
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath
                ("//*[contains(@class, 'boards-page-board-section-header-icon-default-image')]/../../../..//li")).size() - 1;
    }

    public void selectFirstBoard() {
        click(By.xpath("//*[contains(@class, 'boards-page-board-section-header-icon-default-image')]/../../../..//li"));
    }

    public void openMenu() {
        if(isElementDisplayed(By.cssSelector(".js-show-sidebar"))){
            click(By.cssSelector(".js-show-sidebar"));
        }
       // click(By.xpath("//span[.='Show menu']"));
    }

    public void deleteBoard() {
        if (!isElementDisplayed(By.cssSelector(".js-open-more"))) {
            click(By.cssSelector(".icon-back"));
        }
        click(By.cssSelector(".js-open-more"));

        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector(".js-delete"));
        click(By.cssSelector(".js-confirm"));
    }
    public boolean isAvatarBoardPresent() {
        return waitForElementPresent(By.xpath("//ul[@class = 'boards-page-board-section-list']"), 20);
    }

}
