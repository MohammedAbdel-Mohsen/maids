package com.maids.librarySystem.book.repositories;

import org.springframework.data.repository.CrudRepository;

import com.maids.librarySystem.book.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
    Book findByIsbn(String isbn);

}
