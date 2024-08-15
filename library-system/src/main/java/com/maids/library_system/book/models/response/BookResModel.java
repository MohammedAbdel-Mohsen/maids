package com.maids.library_system.book.models.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookResModel implements Serializable {

	private int id;
	private String author;
	private String title;
	private String isbn;
	private int publicationYear;
}
