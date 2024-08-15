package com.maids.library_system.book.services;

import com.maids.library_system.book.models.request.BookReqModel;
import com.maids.library_system.book.models.response.BookResModel;

import java.util.List;

public interface BookService {
    BookResModel createBook(BookReqModel bookReqModel);

    BookResModel updateBook(int bookId, BookReqModel bookReqModel);

    BookResModel getBookById(int bookId);

    List<BookResModel> getAllBooks();

    void deleteBookById(int bookId);
}
