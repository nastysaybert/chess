package com.company.model.figures;

import com.company.model.*;

import java.util.ArrayList;

public class Pawn extends Figure {

    public Pawn (Color color, byte i, byte j){
        super(color, i, j);
    }

    public boolean moveTo(byte i, byte j) {
        return true;
    }

    public ArrayList<Way> possibleMovesList (byte posI, byte posJ){
        ArrayList<Way> possibleMoves = new ArrayList<Way>();
        Position pos = new Position (posI, posJ);
        Way w = new Way();
        w.add(pos);

        //если первый ход, пешка может идти на 2 клетки вперед
        /*if (board.getMoveCount() == 1){
            pos.upPosition(getFigureColor());
            w.add(pos);
            pos.upPosition(getFigureColor());
            w.add(pos);
            if (pos.inBoard()){
                possibleMoves.add(w.clone());
            }
        } else {*/
            pos.upPosition(getFigureColor());
            if (pos.inBoard()){
                possibleMoves.add(w.clone());
            }
        //}
        return possibleMoves;
    }

    public void print(){
        System.out.print((getFigureColor() == Color.WHITE) ? "wPn  " : "bPn  ");
    }


}