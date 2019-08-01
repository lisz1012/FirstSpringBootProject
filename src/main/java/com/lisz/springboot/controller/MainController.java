package com.lisz.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	//@ResponseBody //这个注释如果打开的话，就会返回前端一个普通的字符串，而不会被当作页面模版的名字，而且返回任何类型都可以,Map都行
	public String list(ModelMap map) { //后端通过spring mvc，在context中来回传值的对象，这里想用它传到list页面上，所以用ResponseBody就不行了
		map.put("name", "Zhang San");//Controller and html在一个上下文里，html加载context中的map的时候需要模版引擎Thymeleaf再从context中把map拿出来解析，context做的是数据传输共享
		map.addAttribute("age", 100); //这一句跟上一句等效
		//Thymeleaf做的是前后端关联，从前面把模版拿过来，从后端把数据拿过来做渲染，模版里得有一些占位符:<h1 th:text="${name}"></h1> th是Thymeleaf的标签
		//这个map就是扔给后端各个组件往里写入数据的，最后会拿到前端去
		return "list";
	}
}
