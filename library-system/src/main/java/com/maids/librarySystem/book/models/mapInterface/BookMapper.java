package com.maids.librarySystem.book.models.mapInterface;

import java.util.List;

import org.mapstruct.Mapper;

import com.maids.librarySystem.book.entities.Book;
import com.maids.librarySystem.book.models.response.BookResModel;

@Mapper(componentModel = "spring")
public interface BookMapper {
	BookResModel mapToBookResModel(Book book); 
	List<BookResModel> mapToBookResModel(Iterable<Book> books); 
}
