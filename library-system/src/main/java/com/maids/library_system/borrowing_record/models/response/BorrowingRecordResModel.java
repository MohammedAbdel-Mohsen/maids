package com.maids.library_system.borrowing_record.models.response;

import com.maids.library_system.book.models.response.BookResModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BorrowingRecordResModel implements Serializable {
	private String comment;
	private int rating;
	private LocalDateTime reviewDate;
	private BookResModel story;
}
