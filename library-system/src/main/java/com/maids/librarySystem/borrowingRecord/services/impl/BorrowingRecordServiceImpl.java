package com.maids.librarySystem.borrowingRecord.services.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maids.librarySystem.book.entities.Book;
import com.maids.librarySystem.book.repositories.BookRepository;
import com.maids.librarySystem.borrowingRecord.entities.BorrowingRecord;
import com.maids.librarySystem.borrowingRecord.repositories.BorrowingRecordRepository;
import com.maids.librarySystem.borrowingRecord.services.BorrowingRecordService;
import com.maids.librarySystem.patron.entities.Patron;
import com.maids.librarySystem.patron.repositories.PatronRepository;

@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService{
	@Autowired
	PatronRepository patronRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BorrowingRecordRepository borrowingRecordRepositroy;
	
	
	@Override
	public int borrowABook(int bookId, int patronId) {
		BorrowingRecord borrowingRecord=new  BorrowingRecord();
		mapToBorrowingRecord(borrowingRecord,bookId,patronId);
		borrowingRecordRepositroy.save(borrowingRecord);
		return borrowingRecord.getId();
	}

	@Override
	@Transactional
	public int returnABook(int bookId, int patronId) {
		BorrowingRecord borrowedBook =borrowingRecordRepositroy.findByBookIdAndPatronId(bookId,patronId);
		borrowedBook.setReturnDate(LocalDate.now());
		borrowingRecordRepositroy.save(borrowedBook);
		return borrowedBook.getId();
	}
	
	private void mapToBorrowingRecord(BorrowingRecord borrowingRecord,int bookId, int patronId) {
		Book book = bookRepository.findById(bookId).get();
		Patron patron = patronRepository.findById(patronId).get();
		borrowingRecord.setPatron(patron);
		borrowingRecord.setBook(book);
		borrowingRecord.setBorrowingDate(LocalDate.now());		
	}

}
