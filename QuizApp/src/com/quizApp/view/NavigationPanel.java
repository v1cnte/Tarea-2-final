package com.quizApp.view;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public final JButton btnAnterior = new JButton("Anterior");
    public final JButton btnSiguiente = new JButton("Siguiente");
    public final JButton btnEnviar    = new JButton("Enviar");

    public NavigationPanel() {
        setLayout(new FlowLayout(FlowLayout.RIGHT,20,0));
        add(btnAnterior);
        add(btnSiguiente);
        add(btnEnviar);
    }
}