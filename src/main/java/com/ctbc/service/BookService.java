package com.ctbc.service;

import java.util.List;

import com.ctbc.domain.Book;

public interface BookService {

	public List<Book> findAll();

	public Book save(Book book);

	public Book findOne(Long id);

	public void deleteOne(Long id);

}
