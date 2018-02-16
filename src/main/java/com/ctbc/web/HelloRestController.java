package com.ctbc.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 使用規則：在類上面添加
// 作用	   ：把類變成web的控制器
// 返回	   ：返回值如果是"字串"就會返回"字串"，如果是"Map"或是"實體對象"就會返回"json"
@RestController
@RequestMapping("/api")
public class HelloRestController {

	// 請求映射
	// 使用規則：在方法或是類上添加
	// 作用 ：URL 解析後，映射到控制器裡面的方法(value)，讓該方法處理web的請求
	// 如果 method 設定是 GET ，那 POST 或其他的方法過來，就會報錯(請求錯誤405)
	// 如果 method 沒有設定，那所有 method 過來皆可
	// 如果只有一個 value 參數，value 可省略
	/* @RequestMapping(value = "/say", method = RequestMethod.POST) */
	@PostMapping("/say") // 為 @RequestMapping(value = "/say", method = RequestMethod.POST) 的簡寫
	public String hello() {
		return "Hello Spring Boot";
	}

}
