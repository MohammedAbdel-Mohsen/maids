package com.maids.librarySystem.book.models.request;

import java.io.Serializable;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookReqModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5896102703122546946L;
	@NotNull
	private String author;
	@NotNull
	private String title;
	@Size(max = 13)
	private String isbn;
	@Min(1)
	private int publicationYear;
}
