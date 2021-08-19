package com.telran.qa28.skelon.framework;

import com.telran.qa28.skelon.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SessionHelper extends HelperBase {
    Properties properties;

    public SessionHelper(WebDriver wd, Properties properties) {
        super(wd);
        this.properties = properties;
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

    public void fillLoginForm(User user) throws InterruptedException {
        type(By.xpath("//*[@name = 'user']"), user.getEmail());
        click(By.xpath("//input[@id='login']"));
        Thread.sleep(2000);
        type(By.xpath("//*[@name = 'password']"), user.getPassword());
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

    public boolean isErrorPresent() {
        return isElementPresent(By.cssSelector("#password-error"));
    }

    public void openUserProfile() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));

    }

    public void goToAtlassinAccount() {
        click(By.cssSelector("[href$='manage-profile']"));
        ArrayList<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
    }
    //

    public void returnToTrelloFromAtlassian() throws InterruptedException {
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.close();
        wd.switchTo().window(tabs.get(0));
        Thread.sleep(1000);
    }
}
