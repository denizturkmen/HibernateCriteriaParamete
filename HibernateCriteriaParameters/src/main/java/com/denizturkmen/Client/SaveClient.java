package com.denizturkmen.Client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.denizturkmen.Entity.Person;
import com.denizturkmen.Util.HibernateUtil;

public class SaveClient {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		try {
			session = sf.openSession();
			session.beginTransaction();

			Person person1 = new Person();
			person1.setName("Deniz TÜRKMEN");
			person1.setNickName("denizm");
			person1.setAddress("Ankara");
			person1.setCreatedOn(new Date());
			person1.setVersion(1);

			Person person2 = new Person();
			person2.setName("Eren Türkmen");
			person2.setNickName("eren");
			person2.setAddress("Çorum");
			person2.setCreatedOn(new Date());
			person2.setVersion(1);

			session.save(person1);
			session.save(person2);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
}
