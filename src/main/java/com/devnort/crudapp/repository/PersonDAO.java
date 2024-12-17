package com.devnort.crudapp.repository;

import com.devnort.crudapp.entity.Person;

import java.util.List;

public interface PersonDAO {
    void save (Person person);
    void delete (Integer id);
    Person get(Integer id);
    List<Person> getAll ();
    void update (Person person);
}
