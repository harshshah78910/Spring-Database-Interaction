package com.harsh.database.SpringDatabasedemi.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.harsh.database.SpringDatabasedemi.entity.Person;

@Repository
@Transactional
public class PersonJpaRepo {

	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person insertOrUpdate(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		 entityManager.remove(findById(id));
	}
}
