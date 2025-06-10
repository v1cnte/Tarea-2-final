package com.quizApp.model;

public abstract class Question {
    private final String texto;
    public Question(String texto) { this.texto = texto; }
    public String getTexto() { return texto; }
}
