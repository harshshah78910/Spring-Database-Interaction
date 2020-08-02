package com.harsh.database.SpringDatabasedemi.springDataJpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsh.database.SpringDatabasedemi.entity.Person;

public interface PersonSpringJpaRepo extends JpaRepository<Person, Integer> {

}
