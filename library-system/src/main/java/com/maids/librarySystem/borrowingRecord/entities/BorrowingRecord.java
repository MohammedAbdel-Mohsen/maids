package com.maids.librarySystem.borrowingRecord.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.maids.librarySystem.book.entities.Book;
import com.maids.librarySystem.patron.entities.Patron;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name ="BorrowingRecord")
public class BorrowingRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1406720365866683295L;

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(nullable=false)
	    private LocalDate borrowingDate;

	    private LocalDate returnDate;

	    @ManyToOne
	    @JoinColumn(name = "PATRON_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_BorrowingRecord_Patron"))
	    private Patron patron;

	    @ManyToOne
	    @JoinColumn(name = "BOOK_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_BorrowingRecord_Book"))
	    private Book book;
}
