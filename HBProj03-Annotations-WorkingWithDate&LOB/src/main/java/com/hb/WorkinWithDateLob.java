package com.hb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Person;

/**
 * Hello world!
 *
 */
public class WorkinWithDateLob 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Project started." );
        
/*      Configuration cfg = new Configuration();
        cfg.configure("com/cfgs/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
*/
        
        //when hibernate.cfg.xml is inside src/main/java folder then u no need to pass cfg.xml file to the configure() method 
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        Person p1 = new Person();
        p1.setName("Binod");
        p1.setLocation("Kasba");
//      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//      Date dob=format.parse("1980-5-22");
        Date dob = new SimpleDateFormat("yyyy-MM-dd").parse("1992-5-29");
        p1.setDob(dob);
        p1.setCurrentDate(LocalDate.now());
        //get image
        InputStream is = new FileInputStream("C:\\Users\\arjun\\OneDrive\\My_save\\docoment\\Desktop\\under50kb.jpeg");
        byte[]  byteArr = new byte[is.available()]; 
        is.read(byteArr);
        p1.setImage(byteArr);		//**
        //get text resume
        Reader w = new FileReader("C:\\Users\\arjun\\OneDrive\\My_save\\docoment\\Desktop\\RESUME.txt");
        File f = new File("C:\\Users\\arjun\\OneDrive\\My_save\\docoment\\Desktop\\RESUME.txt");
        char[] charArr = new char[(int) f.length()];
        w.read(charArr);		
        p1.setResume(charArr);		//**
        
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p1);
        tx.commit();
        session.close();
        
        System.out.println("person data saved into db.");
        
    }
}













