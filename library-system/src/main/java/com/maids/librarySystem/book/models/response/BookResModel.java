package com.maids.librarySystem.book.models.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookResModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -644409175997579663L;
	private int id;
	private String author;
	private String title;
	private String isbn;
	private int publicationYear;
}
