package com.telran.qa28.skelon.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }

    }

    public void waitForElement(By locator, int timeOut) {
        new WebDriverWait(wd, timeOut).
                until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickOnPlusButton() {
        click(By.xpath("//*[@data-test-id='header-create-menu-button']"));
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public boolean isElementDisplayed(By locator) {
        return wd.findElement(locator).isDisplayed();
    }

    public boolean waitForElementPresent(By locator, int timeOut) {
        return new WebDriverWait(wd, timeOut).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).size() > 0;
    }

    public boolean waitForElementPresentTryCatch(By locator, int timeOut) {
        try {
            waitForElement(locator, timeOut);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void returnOnHomePage() {
        waitForElement(By.cssSelector("[aria-label='HouseIcon']"), 20);
        click(By.cssSelector("[aria-label='HouseIcon']"));
    }

    public void confirmAction() {
        click(By.cssSelector(".js-confirm"));
    }
}
