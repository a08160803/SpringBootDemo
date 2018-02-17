package com.ctbc.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "book") // 群體塞值進去的概念，參數給前綴，要使用時使用 @Autowired 注入
public class Book {

	private String name;
	private String author;
	private String isbn;
	private String description;

	public Book() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", isbn=" + isbn + ", description=" + description + "]";
	}

}
