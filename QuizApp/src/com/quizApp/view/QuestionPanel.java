package com.quizApp.view;

import com.quizApp.model.DevelopmentQuestion;
import com.quizApp.model.MultipleChoiceQuestion;
import com.quizApp.model.Question;
import com.quizApp.model.TrueFalseQuestion;
import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JLabel lblNumero;
    private final JTextArea txtPregunta;
    private final JPanel panelRespuestas;
    
    // para acceso externo:
    private ButtonGroup opcionesGroup;
    private JTextArea areaDev;

    public QuestionPanel() {
        setLayout(new BorderLayout(10,10));
        lblNumero = new JLabel();
        add(lblNumero, BorderLayout.NORTH);

        txtPregunta = new JTextArea(3,60);
        txtPregunta.setLineWrap(true);
        txtPregunta.setWrapStyleWord(true);
        txtPregunta.setEditable(false);
        add(new JScrollPane(txtPregunta), BorderLayout.CENTER);

        panelRespuestas = new JPanel();
        add(panelRespuestas, BorderLayout.EAST);
    }

    public void mostrarPregunta(Question q, int idx, int total) {
        lblNumero.setText("Pregunta " + (idx+1) + " de " + total);
        txtPregunta.setText(q.getTexto());
        panelRespuestas.removeAll();

        if (q instanceof TrueFalseQuestion) {
            mostrarTF((TrueFalseQuestion) q);
        } else if (q instanceof MultipleChoiceQuestion) {
            mostrarMC((MultipleChoiceQuestion) q);
        } else {
            mostrarDev((DevelopmentQuestion) q);
        }
        revalidate();
        repaint();
    }

    private void mostrarTF(TrueFalseQuestion q) {
        opcionesGroup = new ButtonGroup();
        panelRespuestas.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
        JRadioButton v = new JRadioButton("Verdadero");
        JRadioButton f = new JRadioButton("Falso");
        opcionesGroup.add(v); opcionesGroup.add(f);
        panelRespuestas.add(v); panelRespuestas.add(f);
    }

    private void mostrarMC(MultipleChoiceQuestion q) {
        opcionesGroup = new ButtonGroup();
        panelRespuestas.setLayout(new BoxLayout(panelRespuestas, BoxLayout.Y_AXIS));
        char[] letras = {'a','b','c','d'};
        for (int i=0; i<q.getOpciones().length; i++) {
            JRadioButton rb = new JRadioButton("(" + letras[i] + ") " + q.getOpciones()[i]);
            rb.setActionCommand(String.valueOf(letras[i]));
            opcionesGroup.add(rb);
            panelRespuestas.add(rb);
            panelRespuestas.add(Box.createVerticalStrut(6));
        }
    }

    private void mostrarDev(DevelopmentQuestion q) {
        panelRespuestas.setLayout(new BorderLayout());
        areaDev = new JTextArea(7,60);
        areaDev.setLineWrap(true);
        areaDev.setWrapStyleWord(true);
        panelRespuestas.add(areaDev, BorderLayout.CENTER);
    }

    /** Devuelve la respuesta marcada o texto desarrollo. */
    public String obtenerRespuesta() {
        if (opcionesGroup != null) {
            ButtonModel sel = opcionesGroup.getSelection();
            return sel == null ? null : sel.getActionCommand();
        }
        return areaDev.getText().trim();
    }
}
