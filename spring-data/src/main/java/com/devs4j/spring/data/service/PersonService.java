/**
 * 
 */
package com.devs4j.spring.data.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devs4j.spring.data.entities.Person;
import com.devs4j.spring.data.repositories.PersonRepository;
import com.github.javafaker.Faker;

/**
 * @author raidentrance
 *
 */
@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	private static final Logger log = LoggerFactory.getLogger(PersonService.class);

	@PostConstruct
	public void init() {
		Faker faker = new Faker();
		for (int i = 0; i < 100; i++) {
			personRepository
					.save(new Person(faker.name().firstName(), faker.funnyName().name(), new Random().nextInt(22)));
		}
	}

	@Transactional
	public void performDatabaseOperations() {
		int size = 10;
		/**
		 * iterating over the pages
		 */
		for (int page = 0; page < size; page++) {
			log.info("Page {} size {} ", page, size);
			Page<Person> people = personRepository.findAll(PageRequest.of(page, size));
			for (Person person : people) {
				log.info("Person {} ", person);
			}

		}
		int countByAge = personRepository.countByAge(5);
		log.info("People of 5 years {}", countByAge);

		List<Person> peopleUnder15 = personRepository.findByAgeBetween(0, 15);
		log.info("People under 15 {}", peopleUnder15.size());
		for (Person person : peopleUnder15) {
			log.info("Under 15 {}", person);
		}

		List<Person> under18 = personRepository.findByAgeLessThan(18);
		log.info("People under 18 {} ", under18.size());
		for (Person person : under18) {
			log.info("Under 18 {}", person);
		}

		log.info("People more than 18 with streams");
		personRepository.findByAgeGreaterThan(18).forEach(p -> log.info("More than 18 {}", p));

		log.info("Looking for Mort Tallity");
		Optional<Person> mark = personRepository.findByLastName("Mort Tallity");
		if (mark.isPresent()) {
			log.info("Mark was found {}", mark.get());
		} else {
			log.info("Mark not found");
		}
	}

	public void performAsyncOperations() {

	}
}
