package com.maids.librarySystem.patron.services;

import java.util.List;

import com.maids.librarySystem.patron.models.request.PatronReqModel;
import com.maids.librarySystem.patron.models.response.PatronResModel;

public interface PatronService {
	int createPatron(PatronReqModel patronReqModel);
	int updatePatron(int patronId,PatronReqModel patronReqModel);
	PatronResModel getPatronById(int patronId);
	List<PatronResModel> getAllPatrons();
	void deletePatronById(int patronId);
}
