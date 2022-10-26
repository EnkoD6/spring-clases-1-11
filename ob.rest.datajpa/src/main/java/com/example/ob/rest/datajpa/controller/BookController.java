package com.example.ob.rest.datajpa.controller;


import com.example.ob.rest.datajpa.entities.Book;
import com.example.ob.rest.datajpa.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    // atributos
    private BookRepository bookRepository;
    // constructores
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    // CRUD sobre la entidad Book

    // Buscar todos los libros (lista de libros)
    @GetMapping("/api/books")
    public List<Book> findAll(){
        //recuperar y devolver los libros de base de datos
        return bookRepository.findAll();
    }
    // buscar un solo libro en base de datos segun su id
    @GetMapping("/api/books/{id}")
    @ApiOperation("Buscar un libro por clave primaria id long")
    public ResponseEntity<Book> findOneById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){

        Optional<Book> bookOpt = bookRepository.findById(id);
        // Opcion 1
        if(bookOpt.isPresent()){
            return ResponseEntity.ok(bookOpt.get());
        } else{
            return ResponseEntity.notFound().build();
        }

        // Opcion 2
        // return bookOpt.orElse(null);
    }

    // crear un nuevo libro en base de datos
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        // guardar el libro recibido por parametro en la base de datos
        if(book.getId() != null){ // quiere decir que existe el id y por tanto no es una creacion
            log.warn("trying to create a book with id");
            System.out.println("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result); // el libro devuelto tiene una carga primaria
    }


    // actualizar un libro existente en base de datos
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){

        if(book.getId() == null){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId())) {
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        // El proceso de actualizacion
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result); // el libro devuelto tiene una clave primaria
    }


    // borrar un libro en base de datos
    @ApiIgnore
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if(!bookRepository.existsById(id)) {
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    // borrar todos los libros de la base de datos
    @ApiIgnore
    @DeleteMapping("/api/book")
    public ResponseEntity<Book> deleteAll(){
        log.info("REST Request for deleting all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
