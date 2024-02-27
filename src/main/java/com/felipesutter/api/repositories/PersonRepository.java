package com.felipesutter.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipesutter.api.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
