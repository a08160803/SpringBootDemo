package com.ctbc.service;

import java.util.List;

import com.ctbc.domain.Book;

public interface BookService {

	public List<Book> findAll();

	public Book save(Book book);

	public Book findOne(Long id);

	public void deleteOne(Long id);

	public List<Book> findBooksByAuthor(String author);

	public List<Book> findByAuthorAndStatus(String author, Integer status);

	public List<Book> findByDescriptionEndsWith(String description);

	public List<Book> findByDescriptionContains(String description);

	public List<Book> findByJPQL(int len);
	
	public int updateByJPQL(Integer status, Long id);
	
	public int deleteByJPQL(Long id);
}
