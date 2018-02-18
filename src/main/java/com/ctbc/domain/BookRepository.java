package com.ctbc.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// https://docs.spring.io/spring-data/jpa/docs/2.0.3.RELEASE/reference/html/#jpa.query-methods
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByAuthor(String author);

	public List<Book> findByAuthorAndStatus(String author, Integer status);

	public List<Book> findByDescriptionEndsWith(String description);

	public List<Book> findByDescriptionContains(String description);

	// 這裡的Book為實體對象的名稱，?後面表示第n個參數
	// @Query("select b from Book b where length(b.name) > ?1")
	// public List<Book> findByJPQL(int len);

	// 這裡的book為數據庫表名，?後面表示第n個參數，nativeQuery = true 為開啟 SQL 查詢
	@Query(value = "select * from book where length(name) > ?1", nativeQuery = true)
	public List<Book> findByJPQL(int len);
}
