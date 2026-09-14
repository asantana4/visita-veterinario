package com.asantana4.learning.visitaveterinario;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean registrarOtra = true;

        while (registrarOtra) {
            limpiarConsola();
            System.out.println("--- Sistema de Vacunación Veterinaria ---");

            System.out.print("\n[1] Perro, [2] Gato -> ");
            String tipoMascota = scanner.nextLine();

            System.out.print("Ingrese el nombre de su mascota -> ");
            String nombre = scanner.nextLine();

            int edadInt = leerEnteroValido("Edad (en años) -> ");
            double pesoDouble = leerDoubleValido("Peso (en libras) -> ");

            Mascota m = tipoMascota.equals("2") ?
                    new Gato(nombre, edadInt, pesoDouble) :
                    new Perro(nombre, edadInt, pesoDouble);

            Veterinario v = new Veterinario();

            limpiarConsola();
            System.out.println("--- Evaluando a " + m.nombre + " ---");

            if (m.puedeSerVacunada()) {
                System.out.println(m.nombre + " puede ser vacunado(a) en esta visita.");
                System.out.print("Escriba 'V' y presione Enter para colocar vacuna, o cualquier otra tecla para cancelar -> ");

                String respuesta = scanner.nextLine();

                limpiarConsola();
                if (respuesta.equalsIgnoreCase("v")) {
                    v.ponerVacuna(m);
                } else {
                    System.out.println("Vacunación cancelada por el usuario.");
                }
            } else {
                System.out.println(m.nombre + " no puede ser vacunado(a) en esta visita.");
                System.out.println("Requisitos: 2 años o más, 3 libras o más, y menos de 3 dosis.");
            }

            System.out.print("\n¿Desea evaluar otra mascota? (S/N) -> ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                registrarOtra = false;
            }
        }

        limpiarConsola();
        System.out.println("Saliendo del sistema...");
    }

    // --- Métodos Auxiliares ---

    private static int leerEnteroValido(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número entero válido.");
            }
        }
    }

    private static double leerDoubleValido(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número decimal válido.");
            }
        }
    }

    /**
     * Intenta limpiar la consola ejecutando comandos del sistema operativo.
     * Si falla (ej. ejecutado dentro de un IDE), imprime líneas en blanco como respaldo.
     */
    private static void limpiarConsola() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Plan B si el comando falla
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}
