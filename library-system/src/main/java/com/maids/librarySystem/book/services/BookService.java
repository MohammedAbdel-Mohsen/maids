package com.maids.librarySystem.book.services;

import java.util.List;

import com.maids.librarySystem.book.models.request.BookReqModel;
import com.maids.librarySystem.book.models.response.BookResModel;

public interface BookService {
	int createBook(BookReqModel bookReqModel);
	int updateBook(int bookId,BookReqModel bookReqModel);
	BookResModel getBookById(int bookId);
	List<BookResModel> getAllBooks();
	void deleteBookById(int bookId);
}
