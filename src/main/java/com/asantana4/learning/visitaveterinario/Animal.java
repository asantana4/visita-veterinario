package com.asantana4.learning.visitaveterinario;

public class Animal {

    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un tipo de sonido.");
    }
}
