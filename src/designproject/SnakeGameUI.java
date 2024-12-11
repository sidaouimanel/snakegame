/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designproject;

/**
 *
 * @author user
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeGameUI extends JFrame {
    private SnakeGame game;

    public SnakeGameUI() {
        game = new SnakeGame();
        this.setTitle("Snake Game");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Gérer les entrées clavier
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        game.getSnake().setDirection(0); // Haut
                        break;
                    case KeyEvent.VK_DOWN:
                        game.getSnake().setDirection(1); // Bas
                        break;
                    case KeyEvent.VK_LEFT:
                        game.getSnake().setDirection(2); // Gauche
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.getSnake().setDirection(3); // Droite
                        break;
                }
            }
        });

        // Utilisation d'un Timer pour mettre à jour et redessiner à intervalle régulier
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.updateGame();
                repaint(); // Redessiner après chaque mouvement
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        game.getSnake().draw(g); // Dessiner le serpent
        g.setColor(Color.RED); // Couleur pour la nourriture
        Point food = game.getFood();
        g.fillRect(food.x * 10, food.y * 10, 10, 10); // Dessiner la nourriture
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SnakeGameUI gameUI = new SnakeGameUI();
            gameUI.setVisible(true);
        });
    }
}
