package com.maids.library_system.book.services.impl;

import com.maids.library_system.book.entities.Book;
import com.maids.library_system.book.models.request.BookReqModel;
import com.maids.library_system.book.models.response.BookResModel;
import com.maids.library_system.book.repositories.BookRepository;
import com.maids.library_system.book.services.BookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper bookMapper;

    @Override
    public BookResModel createBook(BookReqModel bookReqModel) {
        Book book = new Book();
        mapBookReqModelToBook(book, bookReqModel);
        book = bookRepository.save(book);
        return bookMapper.map(book, BookResModel.class);
    }

    @Override
    public BookResModel updateBook(int bookId, BookReqModel bookReqModel) {
        Book updatedBook = bookRepository.findById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        mapBookReqModelToBook(updatedBook, bookReqModel);
        updatedBook = bookRepository.save(updatedBook);
        return bookMapper.map(updatedBook, BookResModel.class);
    }

    @Override
    public BookResModel getBookById(int bookId) {
        Book updatedBook = bookRepository.findById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        return bookMapper.map(updatedBook, BookResModel.class);
    }

    @Override
    public List<BookResModel> getAllBooks() {
        return Collections.singletonList(bookMapper.map(bookRepository.findAll(), BookResModel.class));
    }

    @Override
    public void deleteBookById(int bookId) {
        bookRepository.deleteById(bookId);
    }

    private void mapBookReqModelToBook(Book book, BookReqModel bookReqModel) {
        book.setAuthor(bookReqModel.getAuthor());
        book.setIsbn(bookReqModel.getIsbn());
        book.setTitle(bookReqModel.getTitle());
        book.setPublicationYear(bookReqModel.getPublicationYear());
    }
}
