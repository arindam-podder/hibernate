package com.sevya.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sevya.entity.Student;
import com.sevya.repository.StudentRepository;

@Component
public class ClientRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		studentRepo.findAll().forEach(s -> System.out.println(s.getName()+" : "+s.getStandard().getName()));
	}

}
