package com.asantana4.learning.visitaveterinario;

public class Perro extends Animal {

    public Perro(String nombre) {
        super(nombre);
    }

@Override
    public void hacerSonido() {
        System.out.println(nombre + " está aullando.");
    }
}
