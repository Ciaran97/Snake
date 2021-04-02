package com.ciaran.snakegame;

import com.ciaran.Objects.Apple;
import com.ciaran.Objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JPanel implements ActionListener {

    public static final int SCALE = 25;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SPEED = 12;

    Apple a = new Apple((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
    Snake s = new Snake(10, 10, 10 , 10);
    Timer t = new Timer(1000 / SPEED, this);

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIDTH * SCALE + 20, HEIGHT * SCALE + 20);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
        f.setVisible(true);
    }

    public SnakeGame() {
        t.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(color(255, 50, 10));
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        g.setColor(color(255, 216, 0));

        for (int xx = 0; xx <= WIDTH * SCALE; xx += SCALE) {
            g.drawLine(xx, 0, xx, HEIGHT * SCALE);
        }

        for (int yy = 0; yy <= HEIGHT * SCALE; yy += SCALE) {
            g.drawLine(0, yy, WIDTH * SCALE, yy);
        }

        for (int d = 0; d < s.length; d++) {
            g.setColor(color(255, 0, 255));
            g.fillRect(s.snakeX[d] * SCALE + 1, s.snakeY[d] * SCALE + 1, SCALE - 1, SCALE - 1);
        }

        g.setColor(color(255, 255, 0));
        g.fillRect(a.positionX * SCALE + 1, a.positionY * SCALE + 1, SCALE - 1, SCALE - 1);
    }

    public Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s.moveSnake();

        if ((s.snakeX[0] == a.positionX) && (s.snakeY[0] == a.positionY)) {
            System.out.println(s.length);
            a.setRandomPosition();
            s.length++;
        }

        for (int k = 1; k < s.length; k++) {
            if ((s.snakeX[k] == a.positionX) && (s.snakeY[k] == a.positionY)) {
                a.setRandomPosition();
            }
        }

        repaint();
    }

    public static void loseGame(){

    }


    private class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent kEve) {
            int key = kEve.getKeyCode();
            System.out.println(key);
            int direction = s.getDirection();
            if ((key == KeyEvent.VK_RIGHT) & direction != 2) s.setDirection(0);
            if ((key == KeyEvent.VK_DOWN) & direction != 3) s.setDirection(1);
            if ((key == KeyEvent.VK_LEFT) & direction != 0) s.setDirection(2);
            if ((key == KeyEvent.VK_UP) & direction != 1) s.setDirection(3);
        }
    }



}
