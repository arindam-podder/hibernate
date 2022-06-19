package com.hb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Friend;
import com.entity.Person;

public class OneToManyManyToOneTest {
	public static void main(String[] args) {
		System.out.println("ONE TO MANY - MANY TO ONE MAPPING/ASSOCIATION. ");
		
		SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();
		
		//--------------------------------------------------------------------//
		
		Person p1 = new Person();
		p1.setId(101);
		p1.setName("Ariko");
		
		Friend f1 = new Friend();
		f1.setId(11);
		f1.setName("A");
		f1.setPerson(p1);
		Friend f2 = new Friend();
		f2.setId(12);
		f2.setName("B");
		f2.setPerson(p1);
		
		List<Friend> friendList = new ArrayList<Friend>();
		friendList.add(f1);
		friendList.add(f2);		
		p1.setFriends(friendList);
		
		
		//--------------------------------------------------------------------//
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		 
		//-----------------------------------------------------------------------//
		
		session.save(p1);
		session.save(f1);
		session.save(f2);
		
		//--------------------------------------------------------------------------//
		
		tx.commit();
		session.close();
		factory.close();
		
		//--------------------------------------------------------------------------//
	
		System.out.println("END OF APPLICATION.");
	}
}
