package com.example.Library.library_system.book.services;

import com.maids.library_system.book.entities.Book;
import com.maids.library_system.book.models.request.BookReqModel;
import com.maids.library_system.book.models.response.BookResModel;
import com.maids.library_system.book.repositories.BookRepository;
import com.maids.library_system.book.services.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    public void testCreateBook() {

        BookReqModel bookReqModel = new BookReqModel("Spring Boot", "Craig Walls", "123456789", 2023);
        Book book = new Book();
        book.setId(1L);
        book.setTitle(bookReqModel.getTitle());
        book.setAuthor(bookReqModel.getAuthor());
        book.setIsbn(bookReqModel.getIsbn());
        book.setPublicationYear(bookReqModel.getPublicationYear());

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        BookResModel bookResModel = bookService.createBook(bookReqModel);

        assertEquals(1L, bookResModel.getId());
        assertEquals("Spring Boot", bookResModel.getTitle());
        assertEquals("Craig Walls", bookResModel.getAuthor());

    }


}
