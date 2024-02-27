package com.felipesutter.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesutter.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
