package com.asantana4.learning.visitaveterinario;

public class Perro extends Mascota {
    public static final int EDAD_MAXIMA = 30;
    public static final double PESO_MAXIMO = 500.0;

    protected Perro(String nombre, int edad, double pesoLb) {
        super(nombre, edad, pesoLb, EDAD_MAXIMA, PESO_MAXIMO);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " está aullando.");
    }
}
