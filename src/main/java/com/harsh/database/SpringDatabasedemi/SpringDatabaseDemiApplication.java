package com.harsh.database.SpringDatabasedemi;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harsh.database.SpringDatabasedemi.entity.Person;
import com.harsh.database.SpringDatabasedemi.jdbc.PersonJdbcDao;
import com.harsh.database.SpringDatabasedemi.jpa.PersonJpaRepo;
import com.harsh.database.SpringDatabasedemi.springDataJpa.PersonSpringJpaRepo;

@SpringBootApplication
public class SpringDatabaseDemiApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDao personJdbcDao;
	
	@Autowired
	PersonJpaRepo repo;
	
	@Autowired
	PersonSpringJpaRepo springReop;

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseDemiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// jdbcWayOfWritingCode();
		// jpaWayOfWritingCode();
		springDataJpaWay();
	}

	private void springDataJpaWay() {
		
		System.out.println(springReop.findAll());
		
		System.out.println(springReop.findById(10000));
		
		Person person = new Person();
		person.setId(10003);
		person.setName("Joffery");
		person.setBirthDate(new Date());
		System.out.println(springReop.save(person));
	}

	private void jpaWayOfWritingCode() {
		
		System.out.println(repo.findById(10001));
		
		Person person = new Person();
		person.setId(10003);
		person.setName("Joffery");
		person.setBirthDate(new Date());
		System.out.println(repo.insertOrUpdate(person));
		
		repo.deleteById(1);
	}

	private void jdbcWayOfWritingCode() {
		System.out.println(personJdbcDao.findAll());
		System.out.println(personJdbcDao.findById(10000));
		System.out.println("Deleting object 10000 " + personJdbcDao.deleteById(10000));
		Person person = new Person();
		person.setId(10003);
		person.setName("Joffery");
		System.out.println("Inerting new Person " + personJdbcDao.insertPerson(person));
		person.setName("Hell-Boy");
		System.out.println("Updating new Person " + personJdbcDao.updatePerson(person));
	}

}
