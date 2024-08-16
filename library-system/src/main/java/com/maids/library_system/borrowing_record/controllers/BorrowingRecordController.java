package com.maids.library_system.borrowing_record.controllers;

import com.maids.library_system.borrowing_record.services.BorrowingRecordService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Validated
@AllArgsConstructor
public class BorrowingRecordController {

	BorrowingRecordService borrowingRecordService;
	

	@PostMapping(path="/borrow/{bookId}/patron/{patronId}")
	public ResponseEntity<Long> borrowABook(@PathVariable("bookId") long bookId,
			@PathVariable("patronId") long patronId){
		return new ResponseEntity<>(borrowingRecordService.borrowABook(bookId,patronId), HttpStatus.OK);
	}
	
	
	@PutMapping(path="/return/{bookId}/patron/{patronId}")
	public ResponseEntity<Long> returnABook(@PathVariable("bookId") long bookId,
			@PathVariable("patronId") long patronId){
		return new ResponseEntity<>(borrowingRecordService.returnABook(bookId,patronId), HttpStatus.OK);
	}

}
