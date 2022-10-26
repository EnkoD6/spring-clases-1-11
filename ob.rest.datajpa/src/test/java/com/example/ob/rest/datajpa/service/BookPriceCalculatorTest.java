package com.example.ob.rest.datajpa.service;

import com.example.ob.rest.datajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatorPrice() {
        // configuracion de la prueba
        Book book = new Book(1L, "El señor de los anillos", "JRR Tolkien", 1000, 49.99, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // se ejecuta el comportamiento a testear
        double price = calculator.calculatePrice(book);
        System.out.println(price);

        // comprobaciones aserciones
        assertTrue(price > 0);
        assertEquals(57.980000000000004,price);
    }
}