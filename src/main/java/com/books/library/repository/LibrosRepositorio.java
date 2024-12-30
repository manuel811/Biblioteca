package com.books.library.repository;

import com.books.library.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrosRepositorio extends JpaRepository<Libro,Long> {
}
