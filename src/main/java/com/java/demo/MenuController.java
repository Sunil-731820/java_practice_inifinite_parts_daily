package com.java.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@RequestMapping(value="/showMenu")
	public List<Menu> list() {
		return service.showMenu();
	}
	

}
