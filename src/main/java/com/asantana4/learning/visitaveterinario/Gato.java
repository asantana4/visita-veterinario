package com.asantana4.learning.visitaveterinario;

public class Gato extends Mascota {
    private static final int EDAD_MAXIMA = 40;
    private static final double PESO_MAXIMO = 50.0;

    protected Gato(String nombre, int edad, double pesoLb) {
        super(nombre, edad, pesoLb, EDAD_MAXIMA, PESO_MAXIMO);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " está maullando.");
    }
}
