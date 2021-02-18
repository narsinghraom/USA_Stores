package com.usastores.xml.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.usastores.xml.bean.StoreBean;

public class HibernateXMLTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		StoreBean bean = new StoreBean();
		bean.setStoreName("ABC");
		bean.setStoreArea("KPHB");
		bean.setZipcode(500082);
		bean.setDistanceInMiles(2.5f);
		session.save(bean);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}

}
