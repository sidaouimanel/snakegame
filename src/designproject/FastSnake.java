/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designproject;

/**
 *
 * @author user
 */
public class FastSnake extends SnakeDecorator {

    public FastSnake(Snake snake) {
        super(snake);
    }

    @Override
    public void move() {
        // Déplacer le serpent plus rapidement
        super.move();
        super.move(); // Double déplacement pour augmenter la vitesse
    }
}