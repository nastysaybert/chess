package com.company.model;

import com.company.model.figures.*;

public class ChessBoard {//В рамках работы программы
    private Figure[][] board = new Figure[8][8];

    public Figure[][] getBoard() {
        return board;
    }

    //вместо setBoard
    public void setBoardPosition(int i, int j, Figure figure) {
        this.board[i][j] = figure;
    }

    public ChessBoard () {
        //стартовая расстановка

        //Белые:
        Color standPlayer = Color.WHITE;

        //ставим пешкии
        for (int i = 0; i < 8; i++){
            board[6][i] = new Pawn(standPlayer, 6,  i);
        }

        //ставим турки
        board[7][0] = new Rook(standPlayer, 7, 0);
        board[7][7] = new Rook(standPlayer, 7,  7);

        //ставим коней
        board[7][1] = new Knight(standPlayer, 7,  1);
        board[7][6] = new Knight(standPlayer, 7,  6);

        //ставим ферзей
        board[7][2] = new Bishop(standPlayer, 7,  2);
        board[7][5] = new Bishop(standPlayer, 7,  5);

        //ставим королеву
        board[7][3] = new Queen(standPlayer, 7,  3);

        //ставиим короля
        board[7][4] = new King(standPlayer, 7,  4);


        //Черные:
        standPlayer = Color.BLACK;

        //ставим пешкии
        for (int i = 0; i < 8; i++){
            board[1][i] = new Pawn (standPlayer, 6,  i);
        }

        //ставим турки
        board[0][0] = new Rook(standPlayer, 0, 0);
        board[0][7] = new Rook(standPlayer, 0, 7);

        //ставим коней
        board[0][1] = new Knight(standPlayer, 0,  1);
        board[0][6] = new Knight(standPlayer, 0,  6);

        //ставим ферзей
        board[0][2] = new Bishop(standPlayer, 0,  2);
        board[0][5] = new Bishop(standPlayer, 0,  5);

        //ставим королеву
        board[0][3] = new Queen(standPlayer, 0,  4);

        //ставиим короля
        board[0][4] = new King(standPlayer, 7,  3);
    }

    public void print(){
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++) {
                if (board[i][j] == null) {
                    System.out.print("null ");
                } else board[i][j].print();
            }
            System.out.println("");
        }
    }

    public Figure getFigureByPosition (Position position){
        return this.board[position.getI()][position.getJ()];
    }

    /*private ArrayList<Move> allowMovesList (ChessBoard board){

    }*/

}
