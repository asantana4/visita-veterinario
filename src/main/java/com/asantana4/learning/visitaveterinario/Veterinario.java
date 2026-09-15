package com.asantana4.learning.visitaveterinario;

public class Veterinario {

    public boolean ponerVacuna(Mascota m) {

        if (m.puedeSerVacunada()) {
            System.out.println("Poniendo la vacuna...");
            m.recibirDosis();
            m.hacerSonido();
            return true;
        }
        return false;
    }
}
