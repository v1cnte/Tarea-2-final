package com.quizApp.controller;

import com.quizApp.model.Answer;
import com.quizApp.model.Question;
import com.quizApp.view.MainWindow;
import com.quizApp.view.NavigationPanel;
import com.quizApp.view.QuestionPanel;
import javax.swing.*;

import java.awt.BorderLayout;
import java.util.*;

public class QuizController {
    private final MainWindow ventana;
    private final QuestionPanel panelPregunta;
    private final NavigationPanel panelNav;
    private final List<Question> preguntas;
    private final Map<Integer,Answer> respuestas = new HashMap<>();
    private int indice = 0;

    public QuizController(int nAlt, int nDev) {
        ventana       = new MainWindow();
        panelPregunta = new QuestionPanel();
        panelNav      = new NavigationPanel();

        preguntas = new com.quizApp.repository.QuestionRepository()
                        .obtenerPreguntas(nAlt, nDev);

        panelNav.btnAnterior.addActionListener(e -> irAnterior());
        panelNav.btnSiguiente.addActionListener(e -> irSiguiente());
        panelNav.btnEnviar   .addActionListener(e -> enviarQuiz());

        ventana.setContent(crearContenido());
        actualizarVista();
        ventana.setVisible(true);
    }

    private JPanel crearContenido(){
        JPanel p = new JPanel(new BorderLayout(10,10));
        p.add(panelPregunta, BorderLayout.CENTER);
        p.add(panelNav, BorderLayout.SOUTH);
        return p;
    }

    private void actualizarVista(){
        panelPregunta.mostrarPregunta(preguntas.get(indice), indice, preguntas.size());
        panelNav.btnAnterior.setEnabled(indice>0);
        panelNav.btnSiguiente.setVisible(indice<preguntas.size()-1);
        panelNav.btnEnviar   .setVisible(indice==preguntas.size()-1);
    }

    private void guardarRespuesta(){
        String resp = panelPregunta.obtenerRespuesta();
        respuestas.put(indice, new Answer(resp, resp));
    }

    private void irAnterior(){
        guardarRespuesta();
        indice--;
        actualizarVista();
    }
    private void irSiguiente(){
        guardarRespuesta();
        indice++;
        actualizarVista();
    }

    private void enviarQuiz(){
        guardarRespuesta();
        // aquí procesas y muestras resultados
        JOptionPane.showMessageDialog(ventana,
            "¡Quiz terminado!");
        ventana.dispose();
    }
}
