package com.maids.library_system.patron.entities;

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
@Table(name ="Patron")
public class Patron implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2140396659527419096L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(length = 50,nullable=false)
	private String email;
	
	@Column(length = 11,nullable=false)
	private String mobile;
}
