package com.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;
import com.entity.Student;

/**
 * Hello world!
 *
 */
public class TestInheritanceMapping 
{
    public static void main( String[] args )
    {
        System.out.println( "HIBERNATE INHERITANCE MAPPING." );
        
        SessionFactory factory = new Configuration().configure("com/cfgs/hibernate.cfg.xml").buildSessionFactory();
        
        //create entity object and add data 
        Student s1 = new Student();
        s1.setName("Arindam"); s1.setSchool("RCHS");
        
        Employee e1 = new Employee();
        e1.setName("Netaji"); e1.setJobRole("SE");
        
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        //save data
        Integer sid =(Integer) session.save(s1);
        Integer eid = (Integer) session.save(e1);
        
        tx.commit();
        session.close();  
        factory.close();
        
        System.out.println("student saved with the id :- "+sid);
        System.out.println("employee saved with the id :- "+eid);
        
    }
}
