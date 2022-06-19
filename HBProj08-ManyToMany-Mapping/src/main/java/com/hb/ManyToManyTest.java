package com.hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;
import com.entity.Project;

public class ManyToManyTest {

	public static void main(String[] args) {
		
		System.out.println("MANY TO MANY ");
		SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();
		
		
		//----------------------------------------------------------------//
		
		
		Employee e1 = new Employee();
		e1.setId(11);
		e1.setName("A");
		
		Employee e2 = new Employee();
		e2.setId(12);
		e2.setName("B");
		
		Project p1 = new Project();
		p1.setId(31);
		p1.setName("Proj1");
		
		Project p2 = new Project();
		p2.setId(32);
		p2.setName("Proj2");
		
		e1.setProjects(List.of(p1,p2));
		e2.setProjects(List.of(p2));
		p1.setEmployees(List.of(e1));
		p2.setEmployees(List.of(e1,e2));
		
		
		//-------------------------------------------------------------------//
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction(); 
		
		//----------------------------------------------------------------------//
		
		session.save(e1);
		session.save(e2);
		
		//session.save(p1);
		//session.save(p2);
		
		
		//------------------------------------------------------------------------//
		
		tx.commit();
		session.close();
		factory.close();

	}
}





