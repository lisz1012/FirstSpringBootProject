package com.lisz.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 在访问http://HOSTNAME:PORT/context-path/Controller_URI/Method_URI
 * http://localhost:80/boot/user/list
 * @Controller加入spring管理，没写scope，单例
 * @author shuzheng
 *
 */
@Controller
@RequestMapping("/user")
public class MainController {
	
	/**
	 * String 类型的返回值会找templates下的模版文件：list.html
	 * html是默认后缀。这个list字符串会被spring mvc拦截到
	 * 此外还必须引入Thymeleaf模版引擎，在pom中右键选择Edit starter，再选择
	 * Thymeleaf
	 * @return
	 */
	@GetMapping("/list")
	@ResponseBody //这个注释如果打开的话，就会返回前端一个普通的字符串，而不会被当作页面模版的名字，而且返回任何类型都可以,Map都行
	public String list() {
		return "list";
	}
}
