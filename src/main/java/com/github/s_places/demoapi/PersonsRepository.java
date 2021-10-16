package com.github.s_places.demoapi;

import org.springframework.data.repository.CrudRepository;


public interface PersonsRepository extends CrudRepository<Person, Integer> {

    // @Override
    // List<Person> findAll();
}
