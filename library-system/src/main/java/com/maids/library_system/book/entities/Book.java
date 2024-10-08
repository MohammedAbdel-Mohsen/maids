package com.maids.library_system.book.entities;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name ="Book")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8822166480694613992L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 250,nullable=false)
	private String author;
	
	@Column(length = 250,nullable=false)
	private String title;
	
	@Column(length = 13,unique = true,nullable=false)
	private String isbn;
	
	@Column(nullable=false)
	private int publicationYear;

}
