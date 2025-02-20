package com.books.library.controllers;

import com.books.library.entities.Libro;
import com.books.library.services.LibrosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("libros")
public class LibrosController {

    @Autowired
    private LibrosServices librosServices;

    @PostMapping("/crear")

    public ResponseEntity<Libro> createBook(@RequestBody Libro libro) {
        Libro libroNuevo = librosServices.create(libro);
        return ResponseEntity.ok(libroNuevo);
    }

    @GetMapping()
    public ResponseEntity<List<Libro>> findAll() {
        List<Libro> libros = librosServices.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> findById(@PathVariable Long id) {
        Libro libroId = librosServices.findById(id).get();
        return  ResponseEntity.status(HttpStatus.OK).body(libroId);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Libro>update(@RequestBody Libro libro,@PathVariable Long id){
        Libro libroActualizado=librosServices.update(libro,id);
        return ResponseEntity.ok(libroActualizado);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
       librosServices.delete(id);
        return  ResponseEntity.ok("Libro con id " +id + " borrado correctamente");
    }
}
