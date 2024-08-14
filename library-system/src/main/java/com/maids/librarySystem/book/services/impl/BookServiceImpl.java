package com.maids.librarySystem.book.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maids.librarySystem.book.entities.Book;
import com.maids.librarySystem.book.models.mapInterface.BookMapper;
import com.maids.librarySystem.book.models.request.BookReqModel;
import com.maids.librarySystem.book.models.response.BookResModel;
import com.maids.librarySystem.book.repositories.BookRepository;
import com.maids.librarySystem.book.services.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookMapper bookMapper;
	
	@Override
	public int createBook(BookReqModel bookReqModel) {
		Book book=new Book();
		mapBookReqModelToBook(book,bookReqModel);
		bookRepository.save(book);
		return book.getId();
	}
	@Override
	public int updateBook(int bookId,BookReqModel bookReqModel) {
		Book updatedBook=bookRepository.findById(bookId).get();
		mapBookReqModelToBook(updatedBook,bookReqModel);
		bookRepository.save(updatedBook);
		return updatedBook.getId();
	}
	@Override
	public BookResModel getBookById(int bookId) {
		Book updatedBook=bookRepository.findById(bookId).get();
		return bookMapper.mapToBookResModel(updatedBook);
	}
	@Override
	public List<BookResModel> getAllBooks () {
		return bookMapper.mapToBookResModel(bookRepository.findAll());
	}
	@Override
	public void deleteBookById (int bookId) {
		bookRepository.deleteById(bookId);
	}
	private void mapBookReqModelToBook(Book book,BookReqModel bookReqModel) {
		book.setAuthor(bookReqModel.getAuthor());
		book.setIsbn(bookReqModel.getIsbn());
		book.setTitle(bookReqModel.getTitle());
		book.setPublicationYear(bookReqModel.getPublicationYear());
	}
}
