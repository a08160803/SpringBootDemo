package com.ctbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctbc.domain.Book;
import com.ctbc.domain.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	/*
	 * 查詢所有的書單列表
	 */
	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	/*
	 * 提交一個書單信息(新增/修改)
	 */
	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	/*
	 * 獲取一條書單信息
	 */
	@Override
	public Book findOne(Long id) {
		return bookRepository.findOne(id);
	}

	/*
	 * 刪除一條書單信息
	 */
	@Override
	public void deleteOne(Long id) {
		bookRepository.delete(id);
	}

}
