/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designproject;

/**
 *
 * @author user
 */
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;
    private int direction; // 0 = haut, 1 = bas, 2 = gauche, 3 = droite

    public Snake() {
        body = new LinkedList<>();
        body.add(new Point(10, 10)); // Position initiale du serpent
        direction = 3; // Direction initiale (droite)
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public void setDirection(int direction) {
        // Empêcher que le serpent fasse demi-tour
        if (this.direction == 0 && direction != 1) this.direction = direction;
        else if (this.direction == 1 && direction != 0) this.direction = direction;
        else if (this.direction == 2 && direction != 3) this.direction = direction;
        else if (this.direction == 3 && direction != 2) this.direction = direction;
    }

    public void move() {
        Point head = body.getFirst(); // La tête du serpent
        Point newHead = null;

        // Calculer la nouvelle tête selon la direction
        switch (direction) {
            case 0: newHead = new Point(head.x, head.y - 1); break; // Haut
            case 1: newHead = new Point(head.x, head.y + 1); break; // Bas
            case 2: newHead = new Point(head.x - 1, head.y); break; // Gauche
            case 3: newHead = new Point(head.x + 1, head.y); break; // Droite
        }

        body.addFirst(newHead); // Ajouter la nouvelle tête
        body.removeLast(); // Supprimer la dernière partie du corps (le serpent se déplace)
    }

    public void grow() {
        // Ajouter une nouvelle partie au serpent (la queue du serpent se rajoute)
        Point tail = body.getLast();
        body.addLast(tail); // Ajouter une nouvelle partie à la fin du serpent
    }

    public void draw(Graphics g) {
        // Dessiner chaque partie du serpent
        for (Point p : body) {
            g.fillRect(p.x * 10, p.y * 10, 10, 10); // Chaque carré représente une partie du serpent
        }
    }
}
