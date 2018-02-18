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

	/*
	 * 根據author查詢書單列表
	 */
	@Override
	public List<Book> findBooksByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	/*
	 * 根據author and status查詢書單列表
	 */
	@Override
	public List<Book> findByAuthorAndStatus(String author, Integer status) {
		return bookRepository.findByAuthorAndStatus(author, status);
	}

	/*
	 * 根據description查詢書單結尾列表 ('%xxx')
	 */
	@Override
	public List<Book> findByDescriptionEndsWith(String description) {
		return bookRepository.findByDescriptionEndsWith(description);
	}

	/*
	 * 根據description查詢書單包含列表 ('%xxx%')
	 */
	@Override
	public List<Book> findByDescriptionContains(String description) {
		return bookRepository.findByDescriptionContains(description);
	}

	/*
	 * 自定義查詢(JPQL)
	 * */
	@Override
	public List<Book> findByJPQL(int len) {
		return bookRepository.findByJPQL(len);
	}

}
