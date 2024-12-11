/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designproject;

import java.awt.Point;

/**
 *
 * @author user
 */

import java.util.LinkedList;

public class GameStateMemento {
    private LinkedList<Point> snakeBody;
    private Point foodPosition;
    private int score;

    public GameStateMemento(LinkedList<Point> snakeBody, Point foodPosition, int score) {
        // Copie des données pour préserver l'immuabilité
        this.snakeBody = new LinkedList<>(snakeBody);
        this.foodPosition = new Point(foodPosition.x, foodPosition.y);
        this.score = score;
    }

    public LinkedList<Point> getSnakeBody() {
        return new LinkedList<>(snakeBody);
    }

    public Point getFoodPosition() {
        return new Point(foodPosition.x, foodPosition.y);
    }

    public int getScore() {
        return score;
    }
}
