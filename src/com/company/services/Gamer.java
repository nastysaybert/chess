package com.company.services;

import com.company.model.*;

public class Gamer {
    private ChessBoard board;
    private Color player;
    private int moveCount;

    public Gamer (){
        this.board = new ChessBoard();
        this.player = Color.WHITE;
        this.moveCount = 0;
    }

    //вместо setPlayer
    public void changePlayer() {
        if (this.player == Color.WHITE){
            this.player = Color.BLACK;
        } else {
            this.player = Color.WHITE;
        };
    }

    public Color getPlayer() {
        return player;
    }

    public ChessBoard getBoard(){
        return this.board;
    }

    //вместо setMoveCount
    public void increaseMoveCount (){
        this.moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void doMove(Move move){
        Mover mover = new Mover();//TODO: опять новый Mover, Mover - подразумевает сервис, каждый раз инициализировать сервис плохо
        this.increaseMoveCount();


        System.out.print("Ход " + this.getMoveCount() + ": ");
        move.print();
        mover.moveFigureByWay(this.getBoard(), move);//TODO: опять же транзитом идет доска, что плохо
        this.changePlayer();
    }
}
