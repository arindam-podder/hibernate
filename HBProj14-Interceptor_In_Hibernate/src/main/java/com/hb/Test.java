package com.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;
import com.interceptor.CustomInterceptor;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.withOptions().interceptor(new CustomInterceptor()).openSession();
		Transaction tx = session.beginTransaction();
		
/*		Employee e1 = new Employee();
		e1.setName("Anik"); e1.setRole("SE");
		
		Employee e2 = new Employee();
		e2.setName("Kanchan"); e2.setRole("UI DESIGNER");
		
		Integer id1 = (Integer) session.save(e1);
		Integer id2 = (Integer) session.save(e2);
*/		
		
		//Employee e2 = session.load(Employee.class, id);
		
		Employee e3=session.get(Employee.class, 1);
		e3.setName("Disha");
		session.update(e3);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
