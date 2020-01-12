package com.company;

import java.util.ArrayList;

public class Bishop extends Figure {

    public Bishop (Color color, byte i, byte j){
        super(color, i, j);
    }

    public boolean MoveTo(byte i, byte j) {
        super.pos_i = i;
        super.pos_j = j;
        return true;
    }

    public ArrayList<Way> MoveTo (ChessBoard board){
        ArrayList<Way> possibleMoves = new ArrayList<Way>();
        Position pos;
        Way w = new Way();


        //опишем вариаци хождения слона
        //#1
        pos = new Position (pos_i, pos_j);
        w.way.add(pos);
        while (pos.InBoard()) {
            w.way.add(pos=pos.DiagonLeftUpPosition(figureColor));
            possibleMoves.add(w);
        }

        //#2
        pos = new Position (pos_i, pos_j);
        w.way.add(pos);
        while (pos.InBoard()) {
            w.way.add(pos=pos.DiagonRightUpPosition(figureColor));
            possibleMoves.add(w);
        }

        //#3
        pos = new Position (pos_i, pos_j);
        w.way.add(pos);
        while (pos.InBoard()) {
            w.way.add(pos=pos.DiagonLeftDownPosition(figureColor));
            possibleMoves.add(w);
        }

        //#4
        pos = new Position (pos_i, pos_j);
        w.way.add(pos);
        while (pos.InBoard()) {
            w.way.add(pos=pos.DiagonRightDownPosition(figureColor));
            possibleMoves.add(w);
        }

        return possibleMoves;
    }

    public void Print(){
        System.out.print((figureColor == Color.WHITE) ? "wBs  " : "bBs  ");
    }
}
