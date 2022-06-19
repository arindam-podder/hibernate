package com.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.StudentWithSchool;
import com.helper.School;

/**
 * Hello world!
 *
 */
public class EmbeddingTest {
	public static void main(String[] args) {
		System.out.println("Project Started.");

		SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();

		StudentWithSchool sws1 = new StudentWithSchool();
		// sws.setId(null)
		sws1.setFirstName("Arindam");
		sws1.setLastName("Podder");
		School school1 = new School();
		school1.setSchoolName("Coronation");
		school1.setSchoolLocation("Bidrohi More");
		sws1.setSchool(school1);
		
		StudentWithSchool sws2 = new StudentWithSchool();
		// sws.setId(null)
		sws2.setFirstName("Arjun");
		sws2.setLastName("Poddar");
		School school2 = new School();
		school2.setSchoolName("Ramkrisna");
		school2.setSchoolLocation("Town club para");
		sws2.setSchool(school2);
		

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(sws1);
		session.save(sws2);

		tx.commit();
		session.close();
		factory.close();

		System.out.println("student deatails and its school details are saved.");
	}

}
