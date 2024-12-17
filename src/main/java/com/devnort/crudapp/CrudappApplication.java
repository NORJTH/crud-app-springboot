package com.devnort.crudapp;

import com.devnort.crudapp.entity.Person;
import com.devnort.crudapp.repository.PersonDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudappApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(PersonDAO personDAO){
		return runner->{
			System.out.println("Hello CRUD App Spring Boot!!");
			//saveData(personDAO);
			//deleteData(personDAO);
			//getData(personDAO);
			getAllData(personDAO);
			updateData(personDAO);
		};
	}

	public void	saveData(PersonDAO personDAO){
		Person obj1 = new Person("สุดหล่อ","มากมาย");
		personDAO.save(obj1);
		System.out.println("Insert Complete!");
	}

	public void deleteData(PersonDAO personDAO){
		int id=1;
		personDAO.delete(id);
		System.out.println("Delete Complete!");
	}

	public void getData(PersonDAO personDAO){
		int id = 3;
		Person person =  personDAO.get(id);
		System.out.println(person);
	}

	public void getAllData(PersonDAO personDAO){
		List<Person> data =  personDAO.getAll();
		for (Person person : data){
			System.out.println(person);
		}
	}

	public void updateData (PersonDAO personDAO){
		int id = 4;
		Person myPerson = personDAO.get(id);
		myPerson.setFname("โตโล่");
		myPerson.setLname("ใจดี");

		personDAO.update(myPerson);
		System.out.println("Update Complete!");
	}
}
