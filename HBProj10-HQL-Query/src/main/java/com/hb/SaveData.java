package com.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.SomeData;

public class SaveData {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();

		// ----------------------------------------------------------------//

//		SomeData data1 = new SomeData();
//		data1.setId(3); data1.setName("C"); data1.setAge(33); data1.setLocation("JK");
		
		SomeData data2 = new SomeData();
		data2.setId(4); data2.setName("D"); data2.setAge(19); data2.setLocation("Mumbai");

		
		// -------------------------------------------------------------------//

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// ----------------------------------------------------------------------//
		
//		session.save(data1);
		session.save(data2);

		// ------------------------------------------------------------------------//

		tx.commit();
		session.close();
		factory.close();
		
		System.out.println("data saved.");

	}

}
