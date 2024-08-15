package com.maids.library_system.patron.models.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class PatronResModel implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 7756129405105031822L;
	
	private int id;
	private String name;
	private String email;
	private String mobile;
}
