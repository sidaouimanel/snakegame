/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designproject;

/**
 *
 * @author user
 */
import java.awt.Point;

public class SnakeGame {
    private Snake snake;
    private Point food;

    public SnakeGame() {
        snake = new Snake();
        spawnFood();  // Génère la première nourriture
    }

    public Snake getSnake() {
        return snake;
    }

    public Point getFood() {
        return food;
    }

    // Génère un point de nourriture à une position aléatoire
    public void spawnFood() {
        // Assurez-vous que la nourriture ne se génère pas sur la position actuelle du serpent
        food = new Point((int)(Math.random() * 40), (int)(Math.random() * 40)); // Taille de la grille (40x40)
        while (snake.getBody().contains(food)) {
            food = new Point((int)(Math.random() * 40), (int)(Math.random() * 40));
        }
    }

    // Met à jour l'état du jeu à chaque itération
    public void updateGame() {
        snake.move();

        // Vérifier si la tête du serpent touche les bords
        Point head = snake.getBody().getFirst();
        if (head.x < 0 || head.x >= 40 || head.y < 0 || head.y >= 40) {
            // Si la tête touche les bords, le jeu est terminé
            // Affichage d'un message d'alerte et fermeture du jeu
            javax.swing.JOptionPane.showMessageDialog(null, "You Lose!", "Game Over", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            System.exit(0); // Ferme le jeu
        }

        // Vérifier si le serpent mange la nourriture
        if (head.equals(food)) {
            snake.grow(); // Le serpent grandit
            spawnFood();  // Générer une nouvelle nourriture
        }
    }
}
