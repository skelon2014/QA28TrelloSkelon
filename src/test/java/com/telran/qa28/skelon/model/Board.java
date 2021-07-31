package com.telran.qa28.skelon.model;

public class Board {
    private  String boardName;

    public String getBoardName() {
        return boardName;
    }

    public Board withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }
}
