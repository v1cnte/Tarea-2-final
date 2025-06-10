package com.quizApp.repository;

import com.quizApp.model.DevelopmentQuestion;
import com.quizApp.model.MultipleChoiceQuestion;
import com.quizApp.model.Question;
import com.quizApp.model.TrueFalseQuestion;
import java.util.*;

public class QuestionRepository {
    private final List<Question> todas;

    public QuestionRepository() {
        todas = new ArrayList<>();
        cargarTrueFalse();
        cargarMultipleChoice();
        cargarDevelopment();
    }

    private void cargarTrueFalse() {
        todas.add(new TrueFalseQuestion("POO permite reutilizar código...(Recordar)", true));
        todas.add(new TrueFalseQuestion("La programación orientada a objetos permite reutilizar código mediante la herencia(Analizar)", true));
        todas.add(new TrueFalseQuestion("Los atributos públicos son más seguros que los privados en programación(Aplicar)", false));
        todas.add(new TrueFalseQuestion("Un método estático necesita una instancia de clase para ser ejecutado(Entender)", false));
        todas.add(new TrueFalseQuestion("El encapsulamiento impide la reutilización de código(Analizar)", false));
        todas.add(new TrueFalseQuestion("Los constructores pueden tener un valor de retorno(Evaluar)", false));
        todas.add(new TrueFalseQuestion("Una clase puede tener múltiples constructores en C++(Analizar)", true));
        todas.add(new TrueFalseQuestion("Los métodos getter permiten acceder a atributos privados(Recordar)", true));
        todas.add(new TrueFalseQuestion("Un objeto puede tener múltiples estados(Recordar)", true));
        todas.add(new TrueFalseQuestion("Las clases pueden contener tanto métodos como atributos(Evaluar)", true));
        todas.add(new TrueFalseQuestion("Un método setter no puede modificar atributos privados(Analizar)", false));

        // ... demás preguntas TF ...
    }

    private void cargarMultipleChoice() {
        todas.add(new MultipleChoiceQuestion("¿Palabra clave para clase en C++?(Recordar)",
             new String[]{"object","structure","class","define"}, 'c'));
        todas.add(new MultipleChoiceQuestion("¿Qué palabra clave se usa para declarar una clase en C++?(Recordar)",
                new String[]{"object", "structure", "class", "define"} ,'c'));
        todas.add(new MultipleChoiceQuestion("¿Cuál es el propósito de un constructor?(Analizar)",
                new String[]{"Eliminar atributos", "Inicializar objetos", "Crear funciones", "Modificar clases"} ,'b'));
        todas.add(new MultipleChoiceQuestion("¿Qué tipo de método permite acceder a atributos privados?(Evaluar)",
                new String[]{"setter", "getter", "constructor", "destructor"} ,'b'));
        todas.add(new MultipleChoiceQuestion("¿Qué opción describe mejor el polimorfismo?(Analizar)",
                new String[]{"Ocultación de información", "Declaración de variables", "Abstracción de datos", "Capacidad de un método para comportarse de diferentes formas"} ,'d'));
        todas.add(new MultipleChoiceQuestion("¿Cuál es la mejor forma de evitar acceso directo a los datos?(Recordar)",
                new String[]{"Usar atributos privados", "Usar métodos públicos", "Usar clases base", "Usar punteros"} ,'a'));
        todas.add(new MultipleChoiceQuestion("¿Qué palabra clave permite la herencia en C++?(Recordar)",
                new String[]{"static", "public", "include", "define"} ,'b'));
        todas.add(new MultipleChoiceQuestion("¿Qué método se llama automáticamente al crear un objeto?(Analizar)",
                new String[]{"setter", "main", "constructor", "getter"} ,'c'));
        todas.add(new MultipleChoiceQuestion("¿Qué se utiliza para liberar recursos en una clase?(Evaluar)",
                new String[]{"destructor", "getter", "setter", "friend"} ,'a'));
        todas.add(new MultipleChoiceQuestion("¿Cuál de las siguientes NO es una característica de la POO?(Analizar)",
                new String[]{"Compilación", "Herencia", "Encapsulamiento", "Polimorfismo"} ,'a'));
        todas.add(new MultipleChoiceQuestion("¿Qué elemento define el comportamiento de un objeto?(Analizar)",
                new String[]{"Método", "Atributo", "Clase", "Objeto"} ,'a'));
        // ... demás preguntas MC ...
    }

    private void cargarDevelopment() {
        todas.add(new DevelopmentQuestion("Explica qué es una clase...(Evaluar)"));
        todas.add(new DevelopmentQuestion("Explica qué es una clase en programación orientada a objetos y cuál es su utilidad(Analizar)"));
        todas.add(new DevelopmentQuestion("Describe con tus palabras qué es un atributo en una clase y entrega un ejemplo(Analizar)"));
        todas.add(new DevelopmentQuestion("¿Qué diferencia hay entre un método getter y un setter? Da un ejemplo de cada uno(Evaluar)"));
        todas.add(new DevelopmentQuestion("¿Por qué se considera importante encapsular los atributos (marcarlos como privados) en una clase?(Recordar))"));
        todas.add(new DevelopmentQuestion("Escribe una clase en C++ llamada Producto que tenga atributos privados y un constructor(Evaluar)"));
        todas.add(new DevelopmentQuestion("¿Cuál es la utilidad del método mostrarInformacion() en la clase Producto?(Analizar)"));
        todas.add(new DevelopmentQuestion("Describe qué validaciones debería tener el método vender() antes de reducir el stock(Crear)"));
        todas.add(new DevelopmentQuestion("Explica qué significa instanciar un objeto de la clase Producto y cómo se realiza en C++(Recordar)"));
        todas.add(new DevelopmentQuestion("¿Qué diferencias hay entre un método normal y uno estático en C++?(Evaluar)"));
        todas.add(new DevelopmentQuestion("Agrega un nuevo método llamado aumentarStock(int unidades) a la clase Producto y explica su funcionalidad(crear)"));
    
// ... demás preguntas Dev ...
    }

    /**
     * Devuelve una lista mezclada con:
     * – Todas las TF
     * – Sublista de MC de tamaño nAlt
     * – Sublista de Dev de tamaño nDev
     */
    public List<Question> obtenerPreguntas(int nAlt, int nDev) {
        List<Question> tf  = filtrar(TrueFalseQuestion.class);
        List<Question> mc  = filtrar(MultipleChoiceQuestion.class);
        List<Question> dev = filtrar(DevelopmentQuestion.class);
        Collections.shuffle(mc);
        Collections.shuffle(dev);

        List<Question> seleccion = new ArrayList<>();
        seleccion.addAll(tf);
        seleccion.addAll(mc.subList(0, Math.min(nAlt, mc.size())));
        seleccion.addAll(dev.subList(0, Math.min(nDev, dev.size())));
        return seleccion;
    }

    private <T extends Question> List<Question> filtrar(Class<T> tipo) {
        List<Question> out = new ArrayList<>();
        for (Question q : todas)
            if (tipo.isInstance(q)) out.add(q);
        return out;
    }
}
