/**
 * 
 */
package com.devs4j.core.autowiring.lifecycle.required;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.core.autowiring.vehicle.Car;
import com.devs4j.core.autowiring.vehicle.Engine;
import com.devs4j.core.autowiring.vehicle.Owner;
import com.devs4j.core.autowiring.vehicle.SteeringWheel;

/**
 * @author maagapi
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { Car.class, Owner.class, Engine.class, SteeringWheel.class })
public class RequiredAutowiring {

	@Autowired
	private Car car;

	@Test
	public void basic_test() {
		car.goForward();
	}
}
