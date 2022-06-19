package com.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.SomeData;

public class PaginationTest {
	
	
	static void pagination(Query<SomeData> query, int pageSize, int pageNo) {
		if( ! (pageSize<=0 || pageNo<=0) ) {
			query.setFirstResult( (pageSize*pageNo)-pageSize );
			query.setMaxResults(pageSize);
			query.getResultList().forEach(System.out::println);
		}
		else {
			System.out.println("pageSize,pageNo  must be positve.");
		}
	}

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		//hql query for getting all data
		Query<SomeData> query = session.createQuery("from SomeData" , SomeData.class);
//		query.getResultList().forEach(System.out::println);
		System.out.println("---------------------------------------------------");
		//pagination in hibernate
		query.setFirstResult(0);
		query.setMaxResults(5);	
//		query.getResultList().forEach(System.out::println);
		
		pagination(query, 3, 2);
		
		session.close();
		factory.close();

	}
}
