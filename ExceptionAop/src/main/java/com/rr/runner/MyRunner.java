package com.rr.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rr.dao.EmpDao;

@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private EmpDao dao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("------- app start ----------");
		
		dao.getEmp();
		System.out.println("------- app end ----------");

	}

}
