package com.books.library.services;

import com.books.library.entities.Libro;
import com.books.library.repository.LibrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

@Service
public class LibrosServices {

    @Autowired
    private LibrosRepositorio librosRepositorio;

    public Libro create(Libro libro) {
        return librosRepositorio.save(libro);
    }

    public List<Libro> findAll() {
        return librosRepositorio.findAll();

    }

    public Optional<Libro> findById(Long id) {
        return librosRepositorio.findById(id);
    }

    public Libro update(Libro libro, Long id) {
        Optional<Libro> libroExiste = librosRepositorio.findById(id); // Obtengo el libro po id y lo meto en una variable

        if (libroExiste.isPresent()) {

            Libro libroExistente = libroExiste.get();

            //Actualizo los libros
            libroExistente.setTitulo(libro.getTitulo());
            libroExistente.setAutor(libro.getAutor());
            libroExistente.setGenero((libro.getGenero()));
            libroExistente.setAnyo(libro.getAnyo());
            libroExistente.setCantidad(libro.getCantidad()); //


            //Guardao libros

            return librosRepositorio.save(libroExistente);

        } else {
            throw new RuntimeException("El libro con ID " + id + " no existe");
        }


    }

    public void delete(Long id) {
        Optional<Libro> libroExistenete = librosRepositorio.findById(id);

        if (libroExistenete.isPresent()) {
            librosRepositorio.deleteById(id);

        } else {
            throw new RuntimeException("No se encontro ningun libro con Id proporcionado ");
        }


    }
}