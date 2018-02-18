package com.ctbc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ctbc.domain.Book;
import com.ctbc.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	private BookService bookService;

	/*
	 * 獲取讀書清單列表
	 */
	@GetMapping("/books")
	public List<Book> getAllBook() {
		return bookService.findAll();
	}

	@PostMapping("/books")
	public Book insertBook(Book book) {
		return bookService.save(book);
	}

	/*
	 * 獲取一條書單信息
	 */
	@GetMapping("/books/{id}")
	public Book getOneBookById(@PathVariable Long id) {
		System.out.println(">>>>>>>>>>>> " + id);
		return bookService.findOne(id);
	}

	/*
	 * 更新一個書單 (跟新增差在傳參數的時候有多給一個id)
	 */
	@PutMapping("/books")
	public Book updateBook(Book book) {
		return bookService.save(book);
	}

	/*
	 * 刪除一條書單信息
	 */
	@DeleteMapping("/books/{id}")
	public void deleteOneBook(@PathVariable Long id) {
		bookService.deleteOne(id);
	}

	// ================================================================================================
	// @PostMapping("/books/by")
	// public List<Book> getBooksByAuthor(@RequestParam String author) {
	// return bookService.findBooksByAuthor(author);
	// }

	// @PostMapping("/books/by")
	// public List<Book> getBooksByAuthorAndStatus(@RequestParam String author,
	// @RequestParam
	// Integer status) {
	// return bookService.findByAuthorAndStatus(author, status);
	// }

	// @PostMapping("/books/by")
	// public List<Book> getBooksByDescriptionEndsWith(@RequestParam String
	// description) {
	// return bookService.findByDescriptionEndsWith(description);
	// }

	// @PostMapping("/books/by")
	// public List<Book> getBooksByDescriptionContains(@RequestParam String
	// description) {
	// return bookService.findByDescriptionContains(description);
	// }

	// @PostMapping("/books/by")
	// public List<Book> findByJPQL(@RequestParam int len) {
	// return bookService.findByJPQL(len);
	// }

	// @PostMapping("/books/by")
	// public int updateByJPQL(@RequestParam Integer status, @RequestParam Long id)
	// {
	// return bookService.updateByJPQL(status, id);
	// }

	@PostMapping("/books/by")
	public int deleteByJPQL(@RequestParam Long id) {
		return bookService.deleteByJPQL(id);
	}
	// ================================================================================================

}
