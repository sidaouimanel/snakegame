/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package designproject;

import javax.swing.SwingUtilities;

/**
 *
 * @author user
 */
public class Designproject {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        // Lance l'interface graphique du jeu
        SwingUtilities.invokeLater(() -> {
            SnakeGameUI gameUI = new SnakeGameUI();
            gameUI.setVisible(true);
        });
    }
    
}
