package com.maids.librarySystem.patron.repositories;

import org.springframework.data.repository.CrudRepository;

import com.maids.librarySystem.patron.entities.Patron;

public interface PatronRepository extends CrudRepository<Patron, Integer>{

}