package com.maids.library_system.borrowing_record.services;

public interface BorrowingRecordService {
	
	int borrowABook (int bookId,int patronId);
	int returnABook (int bookId,int patronId);
}
