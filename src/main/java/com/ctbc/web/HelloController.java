package com.ctbc.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 使用規則：在類上面添加
// 作用	   ：把類變成web的控制器
// 返回	   ：返回值如果是"字串"就會映射到"模板"
@Controller
@RequestMapping("/api/v1")
public class HelloController {

	@GetMapping("/books")
	public String getAllBookPage() {
		return "books";
	}

	// ==================================================================================================================
	// ==================================================================================================================
	// 加上 @ResponseBody(等同於@RestController)
	// 返回值如果是"字串"就會返回"字串"
	@GetMapping("/books/string")
	@ResponseBody
	public String getAllReturnString() {
		return "books";
	}

	// 返回值如果是"Map"或是"實體對象"就會返回"json"
	// 如果返回 Object 但沒有加 @ResponseBody 的話，會丟出500
	@GetMapping("/books/object")
	@ResponseBody
	public Object getAllReturnObject() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "hello");
		map.put("age", 18);
		return map;
	}
	// ==================================================================================================================
	// ==================================================================================================================

	// ==================================================================================================================
	// ==================================================================================================================
	// 正則表達式: {參數名:正則表達式}
	@GetMapping("/books/{id}/{username:[a-z_]+}")
	@ResponseBody
	public Object getOne(@PathVariable /* 獲取路徑上的參數，會將字串型別自動轉換 */ long id, @PathVariable String username) {
		System.out.println("id = " + id + " ，username = " + username);
		Map<String, Object> book = new HashMap<>();
		book.put("name", "從零開始");
		book.put("isbn", "987654321");
		book.put("author", "我不知道作者是誰");
		book.put("username", username);
		return book;
	}

	// 正則表達式: {參數名:正則表達式}
	@GetMapping("/books/different/{id}/{username:[a-z_]+}")
	@ResponseBody
	public Object getOneDifferent(@PathVariable("id") long bid /* 如果"變數名稱"跟"路徑參數名稱"不同的話，需要給參數(相同可省略) */,
			@PathVariable String username) {
		System.out.println("bid = " + bid + " ，username = " + username);
		Map<String, Object> book = new HashMap<>();
		book.put("name", "從零開始");
		book.put("isbn", "987654321");
		book.put("author", "我不知道作者是誰");
		book.put("username", username);
		return book;
	}
	// ==================================================================================================================
	// ==================================================================================================================

}
