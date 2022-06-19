package com.hb;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.entity.SomeData;

public class NativeSqlTest {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		//native sql , db dependent 
		String sql = "select * from data_for_hql";
		NativeQuery<Object[]> nq = session.createSQLQuery(sql);		
		List<Object[]> list= nq.list();
		list.forEach( arr -> System.out.println(Arrays.toString(arr) ));
		
		
		session.close();
		factory.close();

	}
}
