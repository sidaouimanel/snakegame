/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designproject;

import java.awt.Graphics;

/**
 *
 * @author user
 */
public abstract class SnakeDecorator extends Snake {
    protected Snake snake;

    public SnakeDecorator(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void move() {
        snake.move();
    }

    @Override
    public void draw(Graphics g) {
        snake.draw(g);
    }
}

