/**
 * 
 */
package com.devs4j.core.aop.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.devs4j.core.aop.annotation.Devs4jCache;
import com.devs4j.spring.models.error.GeneralRuntimeException;
import com.devs4j.spring.models.people.Person;

/**
 * @author raidentrance
 *
 */
@Repository
public class PersonComplexDao {

	private List<Person> people;

	private static final Logger log = LoggerFactory.getLogger(PersonComplexDao.class);

	@PostConstruct
	public void init() {
		people = new ArrayList<>();
		people.add(new Person("JASA23849", "Juan", "Sanchez", 19));
		people.add(new Person("AABA88384", "Alex", "Bautista", 30));
		people.add(new Person("ARC283923", "Arturo", "Catalan", 32));
	}

	public List<Person> findAll() {
		return people;
	}

	public Optional<Person> findByName(String name) {
		addDelay();
		return people.stream().filter(p -> p.getName().equals(name)).findAny();
	}

	@Devs4jCache(collection = "people-by-rfc", classType = Person.class)
	public Person findByRfc(String rfc) {
		addDelay();
		return people.stream().filter(p -> p.getRfc().equals(rfc)).findAny().orElse(null);
	}

	public void create(Person person) {
		Person found = findByRfc(person.getRfc());
		if (found == null) {
			people.add(person);
		} else {
			throw new GeneralRuntimeException(String.format("Person %s already exists", person.getRfc()));
		}
	}

	private void addDelay() {
		try {
			int randomInt = new Random().nextInt(10000);
			log.info("Waiting {} miliseconds", randomInt);
			Thread.sleep(randomInt);
		} catch (InterruptedException e) {
			throw new GeneralRuntimeException(e.getMessage());
		}
	}

}
