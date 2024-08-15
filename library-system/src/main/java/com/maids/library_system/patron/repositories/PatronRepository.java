package com.maids.library_system.patron.repositories;

import org.springframework.data.repository.CrudRepository;

import com.maids.library_system.patron.entities.Patron;

public interface PatronRepository extends CrudRepository<Patron, Integer>{

}