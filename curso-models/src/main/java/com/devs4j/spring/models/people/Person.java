package com.devs4j.spring.models.people;

/**
 * 
 * @author raidentrance
 *
 */
public class Person {
	private String rfc;
	private String name;
	private String lastName;
	private int age;

	public Person() {
	}

	public Person(String rfc, String name, String lastName, int age) {
		this.rfc = rfc;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [rfc=" + rfc + ", name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}

}
