package com.telran.qa28.skelon.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class AtlassianHelper extends HelperBase {
    public AtlassianHelper(WebDriver wd) {
        super(wd);
    }

    public void initChangePhoto() {
        new Actions(wd).moveToElement(
                wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']")))
                .pause(3).click(wd.findElement(By.cssSelector("[data-test-selector='trigger-avatar-picker']"))).perform();//[.css-fbv3aj]
        click(By.xpath("//*[@role='menuitem'][1]"));
    }

    public void uploadPhoto() throws InterruptedException {
        //    click(By.xpath("//span[contains(text(),'Upload a photo')]"));
        attachFile(By.cssSelector("[id=image-input]")
                , new File("C:\\Users\\User\\OneDrive\\Documents\\GitHub\\QA28TrelloSkelon\\src\\IMG-20210417-WA0005.jpg"));
        waitForElementAndclick(By.xpath("//*[contains(.,'Upload')]/.."), 10);
        Thread.sleep(5000);

    }
}
