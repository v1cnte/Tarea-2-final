package com.quizApp.model;

public class TrueFalseQuestion extends Question {
    private final boolean correcta;
    public TrueFalseQuestion(String texto, boolean correcta) {
        super(texto);
        this.correcta = correcta;
    }
    public boolean esCorrecta(boolean respuesta) {
        return respuesta == correcta;
    }
}