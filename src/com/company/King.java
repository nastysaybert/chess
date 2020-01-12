package com.company;

public class King extends Figure {

    public King (Color color, byte i, byte j){
        super(color, i, j);
    }

    public boolean MoveTo(byte i, byte j) {
        super.pos_i = i;
        super.pos_j = j;
        return true;
    }

    public void Print(){
        System.out.print((figureColor == Color.WHITE) ? "wK   " : "bK   ");
    }

}