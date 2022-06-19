 package com.hb;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.SomeData;

public class HqlQuery {

	public static void main(String[] args) {
		
		System.out.println("HQL QUERY TEST.");
		SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();
		
		//----------------------------------------------------------------//
		
		
		
		//-------------------------------------------------------------------//
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction(); 
		
		//----------------------------------------------------------------------//
		
//		String getQuery = "from SomeData";
//		Query<SomeData> query1 = session.createQuery(getQuery, SomeData.class);
//		List<SomeData> list = query1.getResultList();		//this method perfect, typed is defined  
//		//List<SomeData> list = query1.list();
//		list.forEach(System.out::println);
		
		String getUniqueQuery = "from SomeData where age=?1";
		Query<SomeData> query= session.createQuery(getUniqueQuery, SomeData.class);
		query.setParameter(1, 32);
		SomeData sd = query.uniqueResult();
		System.out.println(sd);
		
//		String updateQuery = "update SomeData set location='WB' where name='B'";
//		Query query2 = session.createQuery(updateQuery);
//		int n = query2.executeUpdate();
//		System.out.println(n + " record updated");
		
		//selecting specific col and multiple records
//		String specifiCol = "select name,age from SomeData";
//		Query<Object[]> query= session.createQuery(specifiCol);
//		List<Object[]> list = query.list();
//		list.forEach(arr -> System.out.println(Arrays.toString(arr)));
		
		//delete operation
//		String deleteQuery = "delete from SomeData where location=:loc";
//		Query query= session.createQuery(deleteQuery);
//		query.setParameter("loc", "no");
//		int n = query.executeUpdate();
//		System.out.println(n + " record deleted.");
		
		//------------------------------------------------------------------------//
		
		tx.commit();
		session.close();
		factory.close();

	}
}





