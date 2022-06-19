package com.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Answer;
import com.entity.Question;

public class CrudTestOnOTO {
	
	private static final String CONFIGURATION_FILE = "com/cfgs/hibernate.cfg.xml";

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure(CONFIGURATION_FILE).buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
/*		Question q = session.get(Question.class, 101);
		//System.out.println(q);
		Answer a = q.getAnswer();
		a.setAnswer("it  is a programing language.");
		q.setAnswer(a);
		
		session.update(a);
*/
		
		Answer a = session.get(Answer.class, 11);
		System.out.println(a.getAnswerId());
		System.out.println(a.getAnswer());
		//System.out.println(a.getQuestion());			//giving error , dont know why...try
				
		
		tx.commit();
		session.close();
		factory.close();

	}

}
