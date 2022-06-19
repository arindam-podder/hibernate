package com.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Answer;
import com.entity.Question;

public class OneToOneTest {
	
 
	private static final String CONFIGURATION_FILE = "com/cfgs/hibernate.cfg.xml";
	
	public static void main(String[] args) {
		System.out.println("ONE TO ONE EXAMPLE.");
		
		SessionFactory factory = new Configuration().configure(CONFIGURATION_FILE).buildSessionFactory();
		
		Question q1 = new Question();
		q1.setQuestionId(101);
		q1.setQuestion("what is java?");  
		Answer a1 = new Answer();
		a1.setAnswerId(11);
		a1.setAnswer("it is a programming language.");
		q1.setAnswer(a1);
		a1.setQuestion(q1);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(q1);
		session.save(a1);
		
		
		
		tx.commit();
		session.close();
		factory.close();
		
	}
}
