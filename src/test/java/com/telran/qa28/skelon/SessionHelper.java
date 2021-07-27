package com.telran.qa28.skelon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SessionHelper extends HelperBase{
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String email, String password) throws InterruptedException {
        //kak v class LoginTrello
        click(By.xpath("//a[@href='/login']"));
        type(By.xpath("//*[@name = 'user']"), email);
        Thread.sleep(2000);
        click(By.xpath("//input[@id='login']"));
        type(By.xpath("//*[@name = 'password']"), password);
        click(By.xpath("//button[@id='login-submit']"));
    }

    public void logout() {
        clickOnAvatar();
        selectLogoutFromDropDownList();
        confirmLogout();

    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void selectLogoutFromDropDownList() {
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    public void confirmLogout() {
        click(By.cssSelector("[data-testid='logout-button']"));
    }

    public boolean checkUserLoggedOut() {
        return wd.getCurrentUrl().equals("https://trello.com/logged-out");
    }

    //===========================================================
    public void clickOnLogin() {
        click(By.xpath("//a[@href='/login']"));
    }

    public void fillLoginForm(String email, String password) throws InterruptedException {
        type(By.xpath("//*[@name = 'user']"), email);
        click(By.xpath("//input[@id='login']"));
        Thread.sleep(2000);
        type(By.xpath("//*[@name = 'password']"), password);
    }

    public void confirmLogin() {
        click(By.xpath("//button[@id='login-submit']"));
    }

    public boolean isAvatarPresent() {
        return isElementPresent(By.xpath("//*[@data-test-id='header-member-menu-button']"));
    }
    public boolean isAvatarBoardPresent() {
        return waitForElementPresent(By.xpath("//ul[@class = 'boards-page-board-section-list']"), 20);
    }

}
