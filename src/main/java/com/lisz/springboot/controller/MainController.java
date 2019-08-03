package com.lisz.springboot.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lisz.springboot.domain.City;
import com.lisz.springboot.service.CityService;

/**
 * 在访问http://HOSTNAME:PORT/context-path/Controller_URI/Method_URI
 * http://localhost:80/boot/user/list
 * @Controller加入spring管理，没写scope，单例
 * @author shuzheng
 *
 */
@Controller
@RequestMapping("/user")
public class MainController { //Controller里写逻辑的跳转和参数的传递
	
	@Autowired
	private CityService cityService;
	
	/**
	 * String 类型的返回值会找templates下的模版文件：list.html
	 * html是默认后缀。这个list字符串会被spring mvc拦截到
	 * 此外还必须引入Thymeleaf模版引擎，在pom中右键选择Edit starter，再选择
	 * Thymeleaf
	 *
	 * 类名和方法名上的注解里的内容要层层累加才能访问到方法
	 * context-path + /user + /list。 如果类名上面没有@RequestMapping注解 
	 * 那直接context-path + /list 来访问方法
	 * @return
	 */
	@GetMapping("/list")
	//@ResponseBody //这个注释如果打开的话，就会返回前端一个普通的字符串，而不会被当作页面模版的名字，而且返回任何类型都可以,Map都行
	public String list(Model model) { //后端通过spring mvc，在context中来回传值的对象，这里想用它传到list页面上，所以用ResponseBody就不行了
		List<City> list = cityService.findAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("id") Integer id, @RequestParam("name") String name, Model model) {
		String success = cityService.add(id, name);
		model.addAttribute("success", success);
		return "add";
	}
	
	@RequestMapping("/addPage")
	public String add() {
		return "add";
	}
}
