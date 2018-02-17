package com.ctbc.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbc.domain.Book;

// 使用規則：在類上面添加
// 作用	   ：把類變成web的控制器
// 返回	   ：返回值如果是"字串"就會映射到"模板"
@Controller
@RequestMapping("/api/v1")
public class HelloController {
	
	// *************************************************************************************
	// ************************************** @Value ***************************************
	// *************************************************************************************
	// 把定義好的屬性值，注入到變量裡面("yml"中定義"class"中使用)
	@Value("${book.name}")
	private String bookname;
	@Value("${book.author}")
	private String author;
	@Value("${book.isbn}")
	private String isbn;
	@Value("${book.description}")
	private String description;
	
	// *************************************************************************************
	// ************************************ @GetMapping ************************************
	// *************************************************************************************
	/* http://localhost:8081/api/v1/books */
	@GetMapping("/books")
	public String getAllBookPage() {
		return "books";
	}

	// *************************************************************************************
	// *********************************** @ResponseBody ***********************************
	// *************************************************************************************
	// 加上 @ResponseBody(等同於@RestController)
	// 返回值如果是"字串"就會返回"字串"
	/* http://localhost:8081/api/v1/books/string */
	@GetMapping("/books/string")
	@ResponseBody
	public String getAllReturnString() {
		return "books";
	}

	// 返回值如果是"Map"或是"實體對象"就會返回"json"
	// 如果返回 Object 但沒有加 @ResponseBody 的話，會丟出500
	/* http://localhost:8081/api/v1/books/object?page=1&size=5 */
	@GetMapping("/books/object")
	@ResponseBody
	public Object getAllReturnObject(@RequestParam int page,
			@RequestParam(value = "size", defaultValue = "5") int size) {

		Map<String, Object> book = new HashMap<>();
		book.put("name", bookname);
		book.put("isbn", isbn);
		book.put("author", author);
		book.put("description", description);
		Map<String, Object> book2 = new HashMap<>();
		book2.put("name", "從零開始2");
		book2.put("isbn", "9999999999");
		book2.put("author", "我不知道作者是誰2");

		List<Map<String, Object>> contents = new ArrayList<>();
		contents.add(book);
		contents.add(book2);

		Map<String, Object> pagemap = new HashMap<>();
		pagemap.put("page", page);
		pagemap.put("size", size);
		pagemap.put("content", contents);

		return pagemap;
	}
	
	
	// *************************************************************************************
	// ***************** @PathVariable => 獲取一些服務器的資源，刪除或修改 *****************
	// *************************************************************************************
	// 正則表達式: {參數名:正則表達式}
	/* http://localhost:8081/api/v1/books/11 */
	@GetMapping("/books/{id}")
	@ResponseBody
	public Object getOne(@PathVariable /* 獲取路徑上的參數，會將字串型別自動轉換 */ long id) {
		return null;
	}

	// 正則表達式: {參數名:正則表達式}
	/* http://localhost:8081/api/v1/books/different/11/enzo */
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

	// *************************************************************************************
	// *********************** @RequestParam => 提交表單、過濾資源 *************************
	// *************************************************************************************
	@PostMapping("/books")
	@ResponseBody
	public Object insertBook(@RequestParam("name") String bookName, @RequestParam String author,
			@RequestParam String isbn) {
		Map<String, Object> book = new HashMap<>();
		book.put("name", bookName);
		book.put("author", author);
		book.put("isbn", isbn);
		return book;
	}

}
