package com.ctbc.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 使用規則：在類上面添加
// 作用	   ：把類變成web的控制器
// 返回	   ：返回值如果是"字串"就會映射到"模板"
@Controller
@RequestMapping("/api")
public class HelloController {

	@GetMapping("/books")
	public String getAllBookPage() {
		return "books";
	}

	// ==================================================================================================================
	// 加上 @ResponseBody(等同於@RestController)
	// 返回值如果是"字串"就會返回"字串"
	@GetMapping("/books/string")
	@ResponseBody
	public String getAllReturnString() {
		return "books";
	}

	// 返回值如果是"Map"或是"實體對象"就會返回"json"
	@GetMapping("/books/object")
	@ResponseBody
	public Object getAllReturnObject() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "hello");
		map.put("age", 18);
		return map;
	}
	// ==================================================================================================================

}
