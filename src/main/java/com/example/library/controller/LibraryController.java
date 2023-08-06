package com.example.library.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/library")
public class LibraryController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getBooks(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		return bookService.getBooks(pageNumber,pageSize);
	}

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable Long id) {
		return bookService.getBookById(id);
	}

	@PostMapping("/book")
	public Book saveBook(@Valid @RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@PutMapping("/book/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
		book.setId(id);
		return bookService.updateBook(book);
	}

	@DeleteMapping("/book")
	public void deleteBook(@RequestParam Long id) {
		bookService.deleteBook(id);
	}
	
	@GetMapping("/books/filteredByType1")
	public ResponseEntity<List<Book>>  getBooksByBookTypeEndsWith (@RequestParam("type") String bookType){
		return new ResponseEntity<List<Book>> (bookService.getBooksByBookTypeEndsWith(bookType),HttpStatus.OK);
	}
	
	@GetMapping("/books/filteredByType2")
	public ResponseEntity<List<Book>>  getBooksByBookTypeStartsWith (@RequestParam("type") String bookType){
		return new ResponseEntity<List<Book>> (bookService.getBooksByBookTypeStartsWith(bookType),HttpStatus.OK);
	}
	
	@GetMapping("/books/filteredByType3")
	public ResponseEntity<List<Book>>  getBooksByBookTypeContains (@RequestParam("type") String bookType){
		return new ResponseEntity<List<Book>> (bookService.getBooksByBookTypeContains(bookType),HttpStatus.OK);
	}
	
	@GetMapping("/books/{bookAuthor}")
	public ResponseEntity<List<Book>>  getBooksByBookAuthor (@PathVariable String bookAuthor){
		return new ResponseEntity<List<Book>> (bookService.getBooksByBookAuthor(bookAuthor),HttpStatus.OK);
	}
	
}
