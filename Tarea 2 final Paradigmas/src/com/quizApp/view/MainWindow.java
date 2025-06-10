package com.quizApp.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contenido;

    public MainWindow() {
        super("QuizApp");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);

        contenido = new JPanel(new BorderLayout(10,10));
        contenido.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        setContentPane(contenido);
    }

    public void setContent(JComponent comp) {
        contenido.removeAll();
        contenido.add(comp, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
