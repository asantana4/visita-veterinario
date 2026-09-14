package com.asantana4.learning.visitaveterinario;

public class Mascota {
    protected String nombre;
    private int edadAños;
    private double pesoLb;
    private int dosisRecibidas;


    protected Mascota(String nombre, int edad, double pesoLb, int edadMax, double pesoMaxLb) {
        if (edad < 0 || edad > edadMax) {
            throw new IllegalArgumentException(String.format("La edad debe estar entre 0 y %d.", edadMax));
        }
        if (pesoLb < 0.0 || pesoLb > pesoMaxLb) {
            throw new IllegalArgumentException(String.format("El peso debe estar entre 0.0 y %f.", pesoMaxLb));
        }
        this.nombre = nombre;
        this.edadAños = edad;
        this.pesoLb = pesoLb;
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un tipo de sonido.");
    }

    public boolean puedeSerVacunada() {

        return edadAños >= 2 && pesoLb >= 3 && dosisRecibidas <= 3;
    }

    public boolean recibirDosis() {

        if (dosisRecibidas < 3) {
            dosisRecibidas++;
            return true;
        }
        return false;
    }

    public int getEdad() {
        return edadAños;
    }

    public double getPesoLb() {
        return pesoLb;
    }

    public int getDosisRecibidas() {
        return dosisRecibidas;
    }
}
