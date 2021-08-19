package com.telran.qa28.skelon.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void waitForElementAndclick(By locator, int time) {
        new WebDriverWait(wd, time)
                .until(ExpectedConditions.elementToBeClickable(locator)).click();

        //  wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }

    }
    public void attachFile(By locator, File file) {
      /*  if (texte. != null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }*/
    wd.findElement(locator).sendKeys(file.getAbsolutePath());
    click(By.xpath("//span[normalize-space()='Upload']"));
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

//====================//open new page/window======================================================
    public void openTabAndSwitchToIt() throws InterruptedException {//open new page and switch to it

        ((JavascriptExecutor)wd).executeScript("window.open()");
       // Thread.sleep(10000);
        List<String>tabs = new ArrayList<>(wd.getWindowHandles());

        wd.switchTo().window(tabs.get(1));
        wd.navigate().to("https://mail.ru");
        Thread.sleep(10000);

    }

}
