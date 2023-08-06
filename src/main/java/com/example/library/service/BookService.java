package com.example.library.service;

import java.util.List;

import com.example.library.model.Book;

public interface BookService {
	List<Book> getBooks(int pageNumber, int pageSize);

	Book saveBook(Book book);

	Book updateBook(Book book);

	void deleteBook(Long id);

	Book getBookById(Long id);

	List<Book> getBooksByBookTypeEndsWith(String bookType);

	List<Book> getBooksByBookTypeStartsWith(String bookType);

	List<Book> getBooksByBookTypeContains(String bookType);
	
	List<Book> getBooksByBookAuthor(String bookAuthor);
}