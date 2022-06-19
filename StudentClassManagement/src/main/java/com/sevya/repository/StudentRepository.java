package com.sevya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sevya.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {	
	
}
