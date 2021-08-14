package com.telran.qa28.skelon.tests;

import com.telran.qa28.skelon.model.Board;
import com.telran.qa28.skelon.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preConditions() throws InterruptedException {
        if (!app.session().isAvatarPresent()) {
            app.session().login("skelon@bk.ru", "Sand2@14");
        }
    }

    @Test
    public void boardCreationTest() throws InterruptedException {

        String boardName = "Board-QA28-" + System.currentTimeMillis() / 3600000;
        Thread.sleep(5000);
        int before = app.board().getBoardsCount();
        //  app.getBoard().createBoard();

        app.board().clickOnPlusButton();
        app.board().selectCreateBoard();
        app.board().fillBoardCreation(new Board().withBoardName(boardName));
        app.board().confirmBoardCreation();
        app.board().waitForAddListButtonInTheBoard();
        String title = app.board().getTitle();
        Assert.assertEquals(title, boardName);

        app.board().returnOnHomePage();
        Thread.sleep(2000);
        int after = app.board().getBoardsCount();
        System.out.println("Boards - " + after);
        Assert.assertEquals(after, before + 1);
    }

    //=================================================================
    @DataProvider
    public Iterator<Object[]> validBoards() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"a"});
        list.add(new Object[]{"123456"});
        list.add(new Object[]{"QWERTY"});
        list.add(new Object[]{"@#$%^"});
        list.add(new Object[]{"A S D F"});

        return list.iterator();
    }

    @Test(dataProvider = "validBoards")
    public void boardCreationTestDataProvider1(String boardName) throws InterruptedException {

        //  String boardName = "Board-QA28-" + System.currentTimeMillis() / 3600000;
        Thread.sleep(5000);
        int before = app.board().getBoardsCount();
        //  app.getBoard().createBoard();

        app.board().clickOnPlusButton();
        app.board().selectCreateBoard();
        app.board().fillBoardCreation(new Board().withBoardName(boardName));
        app.board().confirmBoardCreation();
        app.board().waitForAddListButtonInTheBoard();
        String title = app.board().getTitle();
        Assert.assertEquals(title, boardName);

        app.board().returnOnHomePage();
        Thread.sleep(2000);
        int after = app.board().getBoardsCount();
        System.out.println("Boards - " + after);
        Assert.assertEquals(after, before + 1);
    }

    //==========================================from file
    @DataProvider
    public Iterator<Object[]> validBoardsCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/boards.csv";
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Board()
                    .withBoardName(split[0])});
            line = reader.readLine();
        }

        return list.iterator();
    }
    @Test(dataProvider = "validBoardsCSV")
    public void boardCreationTestDataProviderCSV(Board board) throws InterruptedException {

        //  String boardName = "Board-QA28-" + System.currentTimeMillis() / 3600000;
        Thread.sleep(4000);
        int before = app.board().getBoardsCount();
        //  app.getBoard().createBoard();

        app.board().clickOnPlusButton();
        app.board().selectCreateBoard();
        app.board().fillBoardCreation(board);
        app.board().confirmBoardCreation();
        app.board().waitForAddListButtonInTheBoard();
        String title = app.board().getTitle();
       // Assert.assertEquals(title, boardName);

        app.board().returnOnHomePage();
        Thread.sleep(2000);
        int after = app.board().getBoardsCount();
        System.out.println("Boards - " + after);
        Assert.assertEquals(after, before + 1);
    }

}

