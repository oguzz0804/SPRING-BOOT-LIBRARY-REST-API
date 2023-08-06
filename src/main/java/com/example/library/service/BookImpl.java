package com.example.library.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.example.library.model.Book;
import com.example.library.repository.LibraryRepository;

@Service
public class BookImpl implements BookService {

	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public List<Book> getBooks(int pageNumber, int pageSize) {
		Pageable pages = PageRequest.of(pageNumber, pageSize,Direction.ASC,"bookYear");
		return libraryRepository.findAll(pages).getContent();
	}

	@Override
	public Book saveBook(Book book) {
		return libraryRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return libraryRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		libraryRepository.deleteById(id);
	}

	@Override
	public Book getBookById(Long id) {
		Optional<Book> book = libraryRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		}
		throw new RuntimeException("Book does not exist with id: " + id);
	}

	@Override
	public List<Book> getBooksByBookTypeEndsWith(String bookType) {
		return libraryRepository.findByBookTypeEndsWith(bookType);
	}

	@Override
	public List<Book> getBooksByBookTypeStartsWith(String bookType) {
		return libraryRepository.findByBookTypeStartsWith(bookType);
	}

	@Override
	public List<Book> getBooksByBookTypeContains(String bookType) {		
		Sort sort = Sort.by(Sort.Direction.ASC, "bookYear");
		return libraryRepository.findByBookTypeContains(bookType,sort);
	}

	@Override
	public List<Book> getBooksByBookAuthor(String bookAuthor) {
		return libraryRepository.findBooksByBookAuthor(bookAuthor);
	}
}
