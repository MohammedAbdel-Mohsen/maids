package com.maids.librarySystem.borrowingRecord.models.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.maids.librarySystem.book.models.response.BookResModel;

import lombok.Data;

@Data
public class BorrowingRecordResModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7153938100195704450L;
	private String comment;
	private int rating;
	private LocalDateTime reviewDate;
	private BookResModel story;
}
