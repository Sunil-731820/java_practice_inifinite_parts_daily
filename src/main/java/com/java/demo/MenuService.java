package com.java.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MenuService {
	@Autowired
	private MenuRepository repo;
	
	public List<Menu> showMenu(){
		return repo.findAll();
	}

}
