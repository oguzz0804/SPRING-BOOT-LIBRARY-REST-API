package com.example.library.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.example.library.model.Book;

@Repository
public interface LibraryRepository extends PagingAndSortingRepository<Book, Long> {
	List<Book> findByBookTypeEndsWith(String bookType);

	List<Book> findByBookTypeStartsWith(String bookType);

	List<Book> findByBookTypeContains(String bookType, Sort sort);

	@Query("FROM Book WHERE bookAuthor = :bookAuthor")
	List<Book> findBooksByBookAuthor(String bookAuthor);

	Book save(Book book);

	void deleteById(Long id);

	Optional<Book> findById(Long id);
}
