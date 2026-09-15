package com.asantana4.learning.visitaveterinario;

public class Gato extends Mascota {
    public static final int EDAD_MAXIMA = 40;
    public static final double PESO_MAXIMO = 50.0;

    protected Gato(String nombre, int edad, double pesoLb) {
        super(nombre, edad, pesoLb, EDAD_MAXIMA, PESO_MAXIMO);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " está maullando.");
    }
}
