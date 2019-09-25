package com.denizturkmen.Client;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.denizturkmen.Entity.Person;
import com.denizturkmen.Util.HibernateUtil;

public class CriteriaQueryParameters {
	public static void main(String[] args) {
		
		String nickName="denizm";
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
			Root<Person> root = criteriaQuery.from(Person.class);
			
			ParameterExpression<String> nickNameParameter = builder.parameter(String.class);
			criteriaQuery.where(builder.equal(root.get("nickName"), nickNameParameter));
			
			Query<Person> query = session.createQuery(criteriaQuery);
			query.setParameter(nickNameParameter, nickName);
			
			List<Person> resultList = query.getResultList();
			for (Person person : resultList) {
				System.out.println(person);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}