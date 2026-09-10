package com.asantana4.learning.visitaveterinario;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class VeterinarioTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to our alternative stream before each test
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void givenValidAnimalObject_whenVaccinating_thenPrintTheMessagesInTheMethod() {
        Animal perro = new Perro("Terry");
        Veterinario vet = new Veterinario();
        vet.ponerVacuna(perro);
        String expectedString = """
                Poniendo la vacula...
                Terry está aullando.
                """


        List<DnaNucleotide> dnaNucleotideList2 = new ArrayList<>(listLength);

        dnaNucleotideList2.add(DnaNucleotide.A);
        dnaNucleotideList2.add(DnaNucleotide.A);
        dnaNucleotideList2.add(DnaNucleotide.C);
        dnaNucleotideList2.add(DnaNucleotide.G);
        dnaNucleotideList2.add(DnaNucleotide.G);
        dnaNucleotideList2.add(DnaNucleotide.T);
        dnaNucleotideList2.add(DnaNucleotide.T);

        DnaStrand dnaStrand2 = new DnaStrand(dnaNucleotideList2, DnaStrandType.CODING);
        String expectedToString2 = "%s%n%s%n%s".formatted( "CODING STRAND",
                "DNA strand: " + "\t\t" + "AACGGTT",
                "RNA complement: " + "\t" + "AACGGUU");
        assertEquals(expectedToString2, dnaStrand2.toString());

    }

    @AfterEach
    public void tearDown() {
        // Restore the original System.out stream after each test
        System.setOut(originalOut);
    }

}
