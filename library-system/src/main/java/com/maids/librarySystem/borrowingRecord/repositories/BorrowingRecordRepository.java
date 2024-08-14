package com.maids.librarySystem.borrowingRecord.repositories;

import org.springframework.data.repository.CrudRepository;

import com.maids.librarySystem.borrowingRecord.entities.BorrowingRecord;

public interface BorrowingRecordRepository extends CrudRepository<BorrowingRecord, Integer>{
	
	BorrowingRecord findByBookIdAndPatronId(int bookId,int patronId);
}
