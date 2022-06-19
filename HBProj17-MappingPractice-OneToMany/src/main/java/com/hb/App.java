package com.hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Contractor;
import com.entity.QualityRating;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	Configuration cfg = new Configuration().configure("com/cfgs/hibernate.cfg.xml");
    	SessionFactory sessionFactory = cfg.buildSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	
//    	Contractor c1 = new Contractor();
//    	c1.setName("ab"); c1.setAddress("raiganj");c1.setRole("SE");
    	
    	QualityRating qr = new QualityRating(9, 7, 7, 7, 7);
    
    	Contractor contractor = session.get(Contractor.class, 1);
    	contractor.setQualityRatings(List.of(qr));
    	session.saveOrUpdate(contractor);
    	
    	transaction.commit();
    	session.close();
    	sessionFactory.close();
    	
    }//main end
}//class end




