package com.maids.library_system.patron.controllers;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maids.library_system.patron.models.request.PatronReqModel;
import com.maids.library_system.patron.models.response.PatronResModel;
import com.maids.library_system.patron.services.PatronService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patrons")
@Validated
@AllArgsConstructor
public class PatronController {

	PatronService patronService;

	
	@PostMapping
	public ResponseEntity<Long> createPatron(
		    @RequestBody @Valid PatronReqModel patronReqModel) {
		return new ResponseEntity<>(patronService.createPatron(patronReqModel), HttpStatus.OK);
	}
	
	
	@PutMapping(path ="/{id}")
	public ResponseEntity<Long> updatePatron(@PathVariable("id") long patronId,
		     @RequestBody @Valid PatronReqModel patronReqModel) {
		return new ResponseEntity<>(patronService.updatePatron(patronId,patronReqModel), HttpStatus.OK);
	}
	
	@GetMapping(path ="/{id}")
	public ResponseEntity<PatronResModel> getPatronById(@PathVariable("id") long patronId) {
		return new ResponseEntity<>(patronService.getPatronById(patronId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<PatronResModel>> getAllPatrons() {
		return new ResponseEntity<>(patronService.getAllPatrons(), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deletePatronById(@PathVariable("id") long patronId){
		patronService.deletePatronById(patronId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
