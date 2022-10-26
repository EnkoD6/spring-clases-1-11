package com.example.ob.rest.datajpa.service;

import com.example.ob.rest.datajpa.entities.Book;

public class BookPriceCalculator {

    public double calculatePrice(Book book){
        double price = book.getPrice();

        if(book.getPages() > 300){
            price += 5;
        }
        // envio
        price += 2.99;
        return price;
    }

}
