package com.quizApp.main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                  UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored){}
            // Pedir cantidad de preguntas
            int alt = Integer.parseInt(
                JOptionPane.showInputDialog(
                  "¿Cuántas de opción múltiple? (0–10)"));
            int dev = Integer.parseInt(
                JOptionPane.showInputDialog(
                  "¿Cuántas de desarrollo? (0–10)"));
            new com.quizApp.controller.QuizController(alt, dev);
        });
    }
}