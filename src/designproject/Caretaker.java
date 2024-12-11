/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designproject;

/**
 *
 * @author user
 */


import java.util.Stack;

public class Caretaker {
    private Stack<GameStateMemento> undoStack = new Stack<>();
    private Stack<GameStateMemento> redoStack = new Stack<>();

    public void save(GameStateMemento memento) {
        undoStack.push(memento);
        redoStack.clear(); // Vider la pile redo lorsqu'un nouvel état est sauvegardé
    }

    public GameStateMemento undo() {
        if (!undoStack.isEmpty()) {
            GameStateMemento memento = undoStack.pop();
            redoStack.push(memento);
            return memento;
        }
        return null;
    }

    public GameStateMemento redo() {
        if (!redoStack.isEmpty()) {
            GameStateMemento memento = redoStack.pop();
            undoStack.push(memento);
            return memento;
        }
        return null;
    }
}
