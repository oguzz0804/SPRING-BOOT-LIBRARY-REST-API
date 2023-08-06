package com.example.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull(message = "Book name should not be null!")
	@Column(name = "book_name", nullable = false, length = 85)
	private String bookName;

	@NotNull(message = "Book's author should not be null!")
	@Column(name = "book_author", nullable = false, length = 100)
	private String bookAuthor;

	@Column(name = "book_type")
	private String bookType;
	
	@Column(name = "book_year")
	private Long bookYear;

	@Column(name = "book_detail", length = 1000)
	private String bookDetail;

	public String getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public Long getBookYear() {
		return bookYear;
	}

	public void setBookYear(Long bookYear) {
		this.bookYear = bookYear;
	}
}
