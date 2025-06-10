package com.quizApp.model;

public class MultipleChoiceQuestion extends Question {
    private final String[] opciones;
    private final char correcta;
    
    public MultipleChoiceQuestion(String texto,
                                  String[] opciones,
                                  char correcta) {
        super(texto);
        this.opciones = opciones;
        this.correcta = Character.toLowerCase(correcta);
    }
    
    public String[] getOpciones() { return opciones; }
    
    public boolean esCorrecta(char r) {
        return Character.toLowerCase(r) == correcta;
    }
    
    public char getOpcionCorrecta() { return correcta; }
}
