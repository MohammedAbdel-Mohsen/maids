package com.maids.librarySystem.patron.models.mapInterface;

import java.util.List;

import org.mapstruct.Mapper;

import com.maids.librarySystem.patron.entities.Patron;
import com.maids.librarySystem.patron.models.response.PatronResModel;

@Mapper(componentModel = "spring")
public interface PatronMapper {
	PatronResModel mapToPatronResModel(Patron patron); 
	List<PatronResModel> mapToPatronResModel(Iterable<Patron> patron); 
}
