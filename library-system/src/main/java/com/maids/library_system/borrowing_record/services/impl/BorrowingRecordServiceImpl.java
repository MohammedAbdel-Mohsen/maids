package com.maids.library_system.borrowing_record.services.impl;

import com.maids.library_system.book.entities.Book;
import com.maids.library_system.book.repositories.BookRepository;
import com.maids.library_system.borrowing_record.entities.BorrowingRecord;
import com.maids.library_system.borrowing_record.repositories.BorrowingRecordRepository;
import com.maids.library_system.borrowing_record.services.BorrowingRecordService;
import com.maids.library_system.patron.entities.Patron;
import com.maids.library_system.patron.repositories.PatronRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class BorrowingRecordServiceImpl implements BorrowingRecordService {
    private final PatronRepository patronRepository;
    private final BookRepository bookRepository;
    private final BorrowingRecordRepository borrowingRecordRepository;


    @Override
    public int borrowABook(int bookId, int patronId) {
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        mapToBorrowingRecord(borrowingRecord, bookId, patronId);
        borrowingRecordRepository.save(borrowingRecord);
        return borrowingRecord.getId();
    }

    @Override
    @Transactional
    public int returnABook(int bookId, int patronId) {
        BorrowingRecord borrowedBook = borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId);
        borrowedBook.setReturnDate(LocalDate.now());
        borrowingRecordRepository.save(borrowedBook);
        return borrowedBook.getId();
    }

    private void mapToBorrowingRecord(BorrowingRecord borrowingRecord, int bookId, int patronId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        Patron patron = patronRepository.findById(patronId).orElseThrow(() -> new RuntimeException("Patron not found"));
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBook(book);
        borrowingRecord.setBorrowingDate(LocalDate.now());
    }

}
