package com.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import com.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
    	cfg.configure("com/cfgs/hibernate.cfg.xml");
    	SessionFactory sf = cfg.buildSessionFactory();
    	
    	/*
    	 * same student(id=1) data retrieving 2 time by same session , one time db hitting because 
    	 * 1st level caching available in hibernate 
    	 */
/*    	Session s1 = sf.openSession();
    	s1.beginTransaction();
    	
    	Student student1 = s1.get(Student.class, 1);
    	System.out.println(student1);
    	System.out.println();
    	Student student2 = s1.get(Student.class, 1);
    	System.out.println(student2);
    	
    	s1.getTransaction().commit();
    	s1.close();
 */   	
    	
    	
    	
    	/*
    	 * same student(id=1) data retrieving by two diff sessioin (s1,s2) , so two time database is hitting. 
    	 */
/*  	Session s1 = sf.openSession();
    	s1.beginTransaction();
    	
    	Student student1 = s1.get(Student.class, 1);
    	System.out.println(student1);
    	
    	s1.getTransaction().commit();
    	s1.close();
    	
    	
    	Session s2 = sf.openSession();
    	s2.beginTransaction();
    	
    	Student student2 = s2.get(Student.class, 1);
    	System.out.println(student2);
    	
    	s2.getTransaction().commit();
    	s2.close();
*/ 
    	
    	
    	
    	/*
    	 * same student(id=1) data retrieving by two diff sessioin (s1,s2) , now, one time database is hitting, because 
    	 * i cofigure 2nd level cache (in xml , entity)
    	 */
/*    	Session s1 = sf.openSession();
    	s1.beginTransaction();
    	
    	Student student1 = s1.get(Student.class, 1);
    	System.out.println(student1);
    	
    	s1.getTransaction().commit();
    	s1.close();
    	
    	
    	Session s2 = sf.openSession();
    	s2.beginTransaction();
    	
    	Student student2 = s2.get(Student.class, 1);
    	System.out.println(student2);
    	
    	s2.getTransaction().commit();
    	s2.close();
*/    	
    	
    	/*
    	 * caching for hql query also, cfgs in xml
    	 */
    	Session session1 = sf.openSession();
    	session1.beginTransaction();
    	
    	Query createQuery1 = session1.createQuery("from Student where id=1");
    	createQuery1.setCacheable(true);
    	Object uniqueResult1 = createQuery1.uniqueResult();		//studet data
    	System.out.println(uniqueResult1);
    	
    	session1.getTransaction().commit();
    	session1.close();
    
    	Session session2 = sf.openSession();
    	session2.beginTransaction();
    	
    	Query createQuery2 = session2.createQuery("from Student where id=1");
    	createQuery2.setCacheable(true);
    	Object uniqueResult2 = createQuery2.uniqueResult();		//studet data
    	System.out.println(uniqueResult2);
    	
    	session2.getTransaction().commit();
    	session2.close();
    
    }
}





















