package com.hb;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;


public class GetStudents 
{
    public static void main( String[] args )
    {
        System.out.println( "project statrted" );
        
        SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();
        
        Session session = factory.openSession();
        
        //get() or load()
        
/*        Student s1 = session.get(Student.class, 66);	//get() give entity , if entity not found with that id value it will give null
        if(s1!=null) {
        	System.out.println("student is :- "+s1);
        }
        else {
        	System.out.println("student with the given id is not present in db.");
        } */
        
        
        try {
        Student s2 = session.load(Student.class, 7); 	//here load() will give proxy(empty) student obj, next line if we use this s2 
        												//then data will be fetched from db and store in the s2 , and if entity is not
        												//present with the given id then it throws 
        												//org.hibernate.ObjectNotFoundException: No row with the given identifier exists
        
        System.out.println(s2);
        }
        catch (ObjectNotFoundException onfe) {
			//onfe.printStackTrace();
			System.out.println("student not present with that given id.");
		}
        
        session.close();
        factory.close();
 
    }
}

























