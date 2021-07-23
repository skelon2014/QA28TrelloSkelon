package com.telran.qa28.skelon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        // Capabilities caps = new DesiredCapabilities();
        init();
    }

    @AfterClass
    public void tearDown() {
        stop();
    }

    //=======================================================
    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openSite("https://trello.com/");
    }
    public void stop() {
        //wd.quit();
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
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

    public void waitForElement(By locator, int timeOut) {
        new WebDriverWait(wd, timeOut).
                until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void fillBoardCreation(String boardName) {
        type(By.xpath("//*[@data-test-id='create-board-title-input']"), boardName);
    }

    public void selectCreateBoard() {
        click(By.xpath("//*[@data-test-id='header-create-board-button']"));
    }

    public void clickOnPlusButton() {
        click(By.xpath("//*[@data-test-id='header-create-menu-button']"));
    }

    public void confirmBoardCreation() {
        click(By.xpath("//*[@data-test-id='create-board-submit-button']"));
    }

    public String getTitle() {
        return wd.findElement(By.xpath("//h1")).getText();
    }
    public boolean isElementPresent(By locator) {
        return  wd.findElements(locator).size()>0;
    }

    public boolean waitForElementPresent(By locator, int timeOut){
       return new WebDriverWait(wd, timeOut).
               until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).size()>0;
    }

    public boolean waitForElementPresentTryCatch(By locator,int timeOut){
        try{
            waitForElement(locator,timeOut);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean isAvatarPresent() {
        return isElementPresent(By.xpath("//*[@data-test-id='header-member-menu-button']"));
    }
    public void waitForAddListButtonInTheBoard() {
        waitForElement(By.cssSelector(".open-add-list"), 15);
    }

    public boolean isAvatarBoardPresent() {
        return waitForElementPresent(By.xpath("//ul[@class = 'boards-page-board-section-list']"), 20);
    }
}
