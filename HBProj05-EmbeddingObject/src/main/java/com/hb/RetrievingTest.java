package com.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.StudentWithSchool;

public class RetrievingTest {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
		StudentWithSchool sws = session.load(StudentWithSchool.class, 2);
		System.out.println("------------------");
		System.out.println(sws);
		System.out.println("------------------");
		System.out.println("school name : "+sws.getSchool().getSchoolName());
		System.out.println("school location : "+sws.getSchool().getSchoolLocation());
		System.out.println("------------------");
		
		session.close();
		factory.close();
	}

}
