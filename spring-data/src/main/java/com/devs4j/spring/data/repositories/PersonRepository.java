/**
 * 
 */
package com.devs4j.spring.data.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.spring.data.entities.Person;

/**
 * @author raidentrance
 *
 */
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

	public int countByAge(int age);

	public List<Person> findByAgeBetween(int start, int end);
	
	public List<Person> findByAgeLessThan(int age);
	
	public Stream<Person> findByAgeGreaterThan(int age);
	
	public Optional<Person> findByLastName(String lasstName);
}
