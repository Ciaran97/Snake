package com.ciaran.Objects;

import com.ciaran.snakegame.SnakeGame;

import java.awt.*;

public class Apple {

    SnakeGame game;

    //X and Y values of the apples position
    public int positionX;
    public int positionY;

    public Apple(int startX, int startY){
        positionX = startX;
        positionY = startY;
    }

    //this method sets a random location for the apple
    public void setRandomPosition(){
        positionY = (int) (Math.random() * game.HEIGHT);
        positionX = (int) (Math.random() * game.WIDTH);

    }


    //encapsulation for the apples position
    public Point getPosition(){
        Point point = new Point(positionX, positionY);

        return point;
    }

}
