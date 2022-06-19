package com.hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchTest {

	public static void main(String[] args) {
		
		System.out.println("MANY TO MANY ");
		SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();
		
		//----------------------------------------------------------------//
		
		
		
		//-------------------------------------------------------------------//
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction(); 
		
		//----------------------------------------------------------------------//
		
		
		
		
		
		
		//------------------------------------------------------------------------//
		
		tx.commit();
		session.close();
		factory.close();

	}
}





