package com.ciaran.Objects;

import com.ciaran.snakegame.SnakeGame;

import java.awt.*;

public class Apple {

    SnakeGame game;

    public int positionX;
    public int positionY;

    public Apple(int startX, int startY){
        positionX = startX;
        positionY = startY;
    }

    public void setRandomPosition(){
        positionY = (int) (Math.random() * game.HEIGHT);
        positionX = (int) (Math.random() * game.WIDTH);

    }

    public Point getPosition(){
        Point point = new Point(positionX, positionY);

        return point;
    }

}
