package com.company.figures;

import com.company.entity.*;

import java.util.ArrayList;

public class King extends Figure {

    public King (Color color, byte i, byte j){
        super(color, i, j);
    }

    public boolean moveTo(byte i, byte j) {
        super.setI(i);
        super.setJ(j);
        return true;
    }

    public ArrayList<Way> possibleMovesList (ChessBoard board){
        ArrayList<Way> possibleMoves = new ArrayList<Way>();
        Position pos;
        Way w;

        //опишем вариаци хождения короля
        //#1
        pos = new Position (getPos_i(), getPos_j());
        w = new Way();
        w.add(pos);
        pos=pos.rightPosition(getFigureColor());        ;
        if (pos.inBoard()){
            w.add(pos);
            possibleMoves.add(w.clone());
        }

        //#2
        pos = new Position (getPos_i(), getPos_j());
        w = new Way();
        w.add(pos);
        pos=pos.leftPosition(getFigureColor());
        if (pos.inBoard()){
            w.add(pos);
            possibleMoves.add(w.clone());
        }

        //#3
        pos = new Position (getPos_i(), getPos_j());
        w = new Way();
        w.add(pos);
        pos=pos.upPosition(getFigureColor());
        if (pos.inBoard()){
            w.add(pos);
            possibleMoves.add(w.clone());
        }

        //#4
        pos = new Position (getPos_i(), getPos_j());
        w = new Way();
        w.add(pos);
        pos=pos.downPosition(getFigureColor());
        if (pos.inBoard()){
            w.add(pos);
            possibleMoves.add(w.clone());
        }

        //#5
        pos = new Position (getPos_i(), getPos_j());
        w = new Way();
        w.add(pos);
        pos=pos.diagonRightUpPosition(getFigureColor());
        if (pos.inBoard()){
            w.add(pos);
            possibleMoves.add(w.clone());
        }

        //#6
        pos = new Position (getPos_i(), getPos_j());
        w = new Way();
        w.add(pos);
        pos=pos.diagonLeftUpPosition(getFigureColor());
        if (pos.inBoard()){
            w.add(pos);
            possibleMoves.add(w.clone());
        }

        //#7
        pos = new Position (getPos_i(), getPos_j());
        w = new Way();
        w.add(pos);
        pos=pos.diagonRightDownPosition(getFigureColor());
        if (pos.inBoard()){
            w.add(pos);
            possibleMoves.add(w.clone());
        }

        //#8
        pos = new Position (getPos_i(), getPos_j());
        w = new Way();
        w.add(pos);
        pos=pos.diagonLeftDownPosition(getFigureColor());
        if (pos.inBoard()){
            w.add(pos);
            possibleMoves.add(w.clone());
        }

        return possibleMoves;
    }

    public void print(){
        System.out.print((getFigureColor() == Color.WHITE) ? "wK   " : "bK   ");
    }

}