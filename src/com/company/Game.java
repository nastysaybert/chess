package com.company;

import com.company.model.*;
import com.company.model.figures.King;
import com.company.services.Checker;
import com.company.services.Gamer;
import com.company.services.Mover;

import java.util.ArrayList;

public class Game {
    Gamer gamer = new Gamer();
    Checker checker = new Checker();//TODO:Сюда ты можешь передать доску И сделать класс синглтоном
    Mover mover = new Mover();

    public void startGame() {
        game:{
            while (true) {
                Position position;
                ArrayList<Move> allowedMovesList = new ArrayList<>();
                for (int row = 0; row < 8; row++) {
                    for (int col = 0; col < 8; col++) {
                        position = new Position(row, col);
                        //смотрим на клетку
                        Figure f = gamer.getBoard().getFigureByPosition(position);//TODO:название f для переменной ниочем не говорит, лучше использовать полное либо такое имя из которого будет понятно что в ней, мне кажется тут подойдет просто figure
                        //если на клетке есть фигура и она принадлежт текущему игроку
                        if ((f != null) && (f.getFigureColor() == gamer.getPlayer())) {//TODO: второе условие достаточно сложно, можно добавить метод в фигуры, где будет проверятся цвет, тогда условие будет f.isColor(gamer.getPlayer())
                            //находим все допустимые ходы данной фигуры
                            ArrayList<Move> am = checker.allowedMoves(f, gamer.getBoard(), row, col, (ArrayList<Move>) allowedMovesList.clone());//TODO: тут ты видимо получается доступные ходы, тогда метод должен быть getAllowedMoves& не надо передавать доску, она должна быть при инициалиизации
                            allowedMovesList = (ArrayList<Move>) am.clone();//TODO: выполни клонирование внутри метода
                            //TODO: ты проходишь все фигуры собираешь все ходы а потом используешь только один ход?

                        }
                    }
                }
                //если допустимые ходы есть, выбираем рандомный
                if (allowedMovesList.size() > 0) {
                    Move m = checker.randomMove(allowedMovesList);
                    if ((m.getFigureInRisk() instanceof King) || (gamer.getMoveCount() == 1000)) {
                        gamer.doMove(m);
                        gamer.getBoard().print();//TODO:вот это почему-то не печаталось
                        System.out.print("And the Winner is... ");
                        System.out.println(gamer.getPlayer() == Color.WHITE ? "Black player!" : "White player!");
                        break game;
                    } else {
                        gamer.doMove(m);
                        //gamer.getBoard().print();
                        //System.out.println();
                    }
                }
            }
        }
    }

}
