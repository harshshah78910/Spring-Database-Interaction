package com.harsh.database.SpringDatabasedemi.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.harsh.database.SpringDatabasedemi.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		return jdbcTemplate.query("Select * from person", new BeanPropertyRowMapper(Person.class));
	}

	public Person findById(int id) {
		return (Person) jdbcTemplate.queryForObject("Select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("Delete from Person where id=?", new Object[] { id });
	}

	public int insertPerson(Person person) {
		return jdbcTemplate.update("insert into person (id, name, birth_date) values (?, ?, sysdate())",
				new Object[] { person.getId(), person.getName() });
	}
	
	public int updatePerson(Person person) {
		return jdbcTemplate.update("update person set name=? where id=?",
				new Object[] {  person.getName(), person.getId() });
	}
}
