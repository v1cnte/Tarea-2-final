package com.quizApp.model;

public class Answer {
    private final String opcionSeleccionada;  // "a","true", etc.
    private final String textoDesarrollo;
    
    public Answer(String opcion, String texto) {
        this.opcionSeleccionada = opcion;
        this.textoDesarrollo   = texto;
    }
    
    public String getOpcionSeleccionada() { return opcionSeleccionada; }
    public String getTextoDesarrollo()    { return textoDesarrollo;    }
}
