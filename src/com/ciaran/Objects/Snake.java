package com.ciaran.Objects;

import com.ciaran.snakegame.SnakeGame;



public class Snake {

    SnakeGame game;

    private int direction = 0;
    public int length = 2;

    public int[] snakeX = new int[SnakeGame.HEIGHT * SnakeGame.WIDTH];
    public int[] snakeY = new int[SnakeGame.HEIGHT * SnakeGame.WIDTH];

    public Snake(int x0, int y0, int x1, int y1){
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1]= x1;
        snakeY[1] = y1;
    }

    public void moveSnake(){
        for (int i = length; i > 0; i--){
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        switch(direction) {
            case 0:
                snakeX[0]++;
                break;
            case 1:
                snakeY[0]++;
                break;
            case 2:
                snakeX[0]--;
                break;
            case 3:
                snakeY[0]--;
                break;
        }
/*
        for(int i = length - 1; i > 0; i--){
            if((snakeX[0] == snakeX[i]) && (snakeX[0] == snakeY[i])){
                length = i - 2;
            }
        }


 */
        if (snakeX[0] > SnakeGame.WIDTH) snakeX[0] = 0;
        if (snakeX[0] < 0) snakeX[0] = SnakeGame.WIDTH - 1;
        if (snakeY[0] > SnakeGame.HEIGHT - 1) snakeY[0] = 0;
        if (snakeY[0] < 0) snakeY[0] = SnakeGame.HEIGHT - 1;

        if (length < 2) length = 2;



    }

    public int getDirection(){
        return direction;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

}
