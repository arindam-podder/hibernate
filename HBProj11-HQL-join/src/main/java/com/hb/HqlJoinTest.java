package com.hb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Friend;
import com.entity.Person;

public class HqlJoinTest {
	public static void main(String[] args) {
		System.out.println(" HQL JOIN QUERY. ");
		
		SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();
	
		Session session = factory.openSession();
		 
		//-----------------------------------------------------------------------//
		
//		Person p = session.get(Person.class, 102);
//		//System.out.println(p);					//Exception in thread "main" java.lang.StackOverflowError
//		System.out.println(p.getName());
//		//p.getFriends().forEach(System.out::println);	//Exception in thread "main" java.lang.StackOverflowError
//		p.getFriends().forEach(f -> System.out.println( f.getId()+" : "+f.getName()) );
//		//p.getFriends().forEach(f -> System.out.println( f.getId()+" : "+f.getName()+" : "+f.getPerson()) );
																		//Exception in thread "main" java.lang.StackOverflowError
		
		
/*		String innerJoin = "select p.name,f.name from Person p INNER JOIN p.friends f ";
		
		String leftJoin = "select p.name,f.name from Person p LEFT JOIN p.friends f ";		
		
		String rightJoin = "select p.name,f.name from Person p RIGHT JOIN p.friends f";
		
		//String fullJoin = "select p.name,f.name from Person p FULL JOIN p.friends f";			//full join not working
		Query<Object[]> q = session.createQuery(leftJoin);	//here passing join query
		List<Object[]> list = q.list();
		list.forEach(arr -> System.out.println(Arrays.toString(arr)) ); 	*/
		
		//join with fetch key word
		System.out.println("INNER JOIN FETCH");
		String innerJoinFetch = "select distinct p from Person p INNER JOIN FETCH p.friends f";
		Query<Person> q1 = session.createQuery(innerJoinFetch);
		List<Person> personList1= q1.getResultList();
		personList1.forEach(p -> System.out.println(p.getName()+" :- "+p.getFriends()));
		
		System.out.println();
		
		System.out.println("LEFT JOIN FETCH");
		String leftJoinFetch = "select p from Person p LEFT JOIN FETCH p.friends f ";
		Query<Person> q2 = session.createQuery(leftJoinFetch);
		List<Person> personList2= q2.getResultList();
		personList1.forEach(p -> System.out.println(p.getName()+" :- "+p.getFriends()));
		
		//--------------------------------------------------------------------------//
		
		session.close();
		factory.close();
		
		//--------------------------------------------------------------------------//
	
		System.out.println("END OF APPLICATION.");
	}
}
