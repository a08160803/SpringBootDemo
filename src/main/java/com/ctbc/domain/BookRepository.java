package com.ctbc.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByAuthor(String author);

	public List<Book> findByAuthorAndStatus(String author, Integer status);

	public List<Book> findByDescriptionEndsWith(String description);
	
	public List<Book> findByDescriptionContains(String description);
}
