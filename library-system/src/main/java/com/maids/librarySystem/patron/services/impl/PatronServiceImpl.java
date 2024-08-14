package com.maids.librarySystem.patron.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maids.librarySystem.patron.entities.Patron;
import com.maids.librarySystem.patron.models.mapInterface.PatronMapper;
import com.maids.librarySystem.patron.models.request.PatronReqModel;
import com.maids.librarySystem.patron.models.response.PatronResModel;
import com.maids.librarySystem.patron.repositories.PatronRepository;
import com.maids.librarySystem.patron.services.PatronService;

@Service
public class PatronServiceImpl implements PatronService{
	@Autowired
	PatronRepository patronRepository;
	
	@Autowired
	PatronMapper patronMapper;
	
	public int createPatron(PatronReqModel patronReqModel) {
		Patron patron=new Patron();
		mapPatronReqModelToPatron(patron,patronReqModel);
		patronRepository.save(patron);
		return patron.getId();
	}
	
	@Override
	public int updatePatron(int patronId, PatronReqModel patronReqModel) {
		Patron updatedPatron=patronRepository.findById(patronId).get();
		mapPatronReqModelToPatron(updatedPatron,patronReqModel);
		patronRepository.save(updatedPatron);
		return updatedPatron.getId();
	}
	
	
	@Override
	public PatronResModel getPatronById(int patronId) {
		Patron patron=patronRepository.findById(patronId).get();
		return patronMapper.mapToPatronResModel(patron);
	}
	
	@Override
	public List<PatronResModel> getAllPatrons() {
		return patronMapper.mapToPatronResModel(patronRepository.findAll());
	}
	
	@Override
	public void deletePatronById(int patronId) {
		patronRepository.deleteById(patronId);
	}
	
	
	private void mapPatronReqModelToPatron(Patron patron,PatronReqModel patronReqModel){
		patron.setName(patronReqModel.getName());
		patron.setEmail(patronReqModel.getEmail());
		patron.setMobile(patronReqModel.getMobile());
	}

}
