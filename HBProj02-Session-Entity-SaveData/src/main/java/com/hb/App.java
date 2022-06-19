package com.hb;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "project statrted" );
        
        //Configuration cfg = new Configuration();
        //cfg.configure("com/cfgs/hibernate.cfg.xml");
        //SessionFactory factory = cfg.buildSessionFactory();		
        	//creation of session factory in single line 
       SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();
        
        //create student obj
        Student s1 = new Student();
        //s1.setId(5);
        s1.setName("Rani Pal");
        //LocalDate ldDate = LocalDate.of(1965, 02, 04);
        s1.setDob(LocalDate.of(2005, 07, 14));
        s1.setLocation("Netaji More");
        
        //create session 
        Session session = factory.openSession();		//*
        //start transaction
        Transaction tx = session.beginTransaction();	//*
        //save student obj  data
        Serializable s = session.save(s1);
        System.out.println(s.getClass());
        System.out.println(s);
        
        tx.commit();
        
        System.out.println("data saved in db.");
        session.close();

        
    }
}








