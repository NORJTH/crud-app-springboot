package com.devnort.crudapp.repository;

import com.devnort.crudapp.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository implements PersonDAO {
    private final EntityManager entityManager;

    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Person person) {
            entityManager.persist(person);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        System.out.println("id ==> "+id);
        Person person =  entityManager.find(Person.class,id);
        System.out.println("Person ==> "+person);
        entityManager.remove(person);

    }

    @Override
    public Person get(Integer id) {
        return entityManager.find(Person.class,id);
    }

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> query =  entityManager.createQuery("FROM Person",Person.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Person person) {
        entityManager.merge(person);
    }
}
