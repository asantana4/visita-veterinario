package com.asantana4.learning.visitaveterinario;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VeterinarioTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to our alternative stream before each test
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    // Format: "input, expected_outcome"
    @CsvSource({
            "Bobby,  30, 500.0",
            "Zeus,   4, 60",
            "Terry,  2, 3",
            "Gladiator, 11, 25"
    })
    @DisplayName("Given a valid Perro object, when vaccinating, then it prints a description of the pet's action")
    void testMethodPonerVacunaOutputForPerro(String name, int age, double weight) {
        Mascota perro = new Perro(name, age, weight);
        Veterinario vet = new Veterinario();
        vet.ponerVacuna(perro);
        String expectedString = """
                Poniendo la vacuna...
                %s está aullando.""".formatted(name);
        String actualOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n");
        assertEquals(expectedString, actualOutput);
    }

    @ParameterizedTest
    // Format: "input, expected_outcome"
    @CsvSource({
            "Jerry,  2, 6.0",
            "Misu,   4, 3.5",
            "Linda,  2, 8.0",
            "Mauricio, 11, 20.0"
    })
    @DisplayName("Given a valid Gato object, when vaccinating, then it prints a description of the pet's action")
    void testMethodPonerVacunaOutputForGato(String name, int age, double weight) {
        Mascota gato = new Gato(name, age, weight);
        Veterinario vet = new Veterinario();
        vet.ponerVacuna(gato);
        String expectedString = """
                Poniendo la vacuna...
                %s está maullando.""".formatted(name);
        String actualOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n");
        assertEquals(expectedString, actualOutput);
    }

    @AfterEach
    public void tearDown() {
        // Restore the original System.out stream after each test
        System.setOut(originalOut);
    }

    @ParameterizedTest
    // Format: "input, expected_outcome"
    @CsvSource({
            "Bobby,  -7",
            "Terry,  31"
    })
    @DisplayName("Given a valid Perro object but invalid Edad, when validating Edad, then it " +
            "throws an illegal argument exception with an error message")
    void testMascotaConstructorThrowsException(String name, int age) {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Perro(name, age, 5.0);
        });

        String expectedString = "La edad debe estar entre 0 y 30.";
        assertEquals(expectedString, exception.getMessage());
    }


}
