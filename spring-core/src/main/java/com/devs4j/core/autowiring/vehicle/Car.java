package com.devs4j.core.autowiring.vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author maagapi
 *
 */
@Service
public class Car {
	private Engine engine;

	private SteeringWheel steeringWheel;

	private Owner owner;

	private static final Logger log = LoggerFactory.getLogger(Car.class);

	@Autowired(required = false)
	public Car(Engine bar, Owner owner) {
		log.info("Engine constructor invoked");
		this.engine = bar;
		this.owner=owner;
	}

	@Autowired(required = false)
	public Car(SteeringWheel steeringWheel, Owner owner) {
		log.info("Steering wheel constructor invoked");
		this.steeringWheel = steeringWheel;
		this.owner=owner;
	}

	@Autowired(required = false)
	public Car(Owner owner) {
		log.info("Owner constructor invoked");
		this.owner = owner;
	}

	@Autowired(required = false)
	public Car(Engine engine, SteeringWheel steeringWheel, Owner owner) {
		super();
		log.info("Using general constructor");
		this.engine = engine;
		this.steeringWheel = steeringWheel;
		this.owner = owner;
	}

	public void goForward() {
		owner.printOwnerName();
		if (engine != null && steeringWheel != null) {
			steeringWheel.goStraight();
			engine.turnOn();
			log.info("The car go forward");
		} else {
			log.info("The has an engine {}", engine != null);
			log.info("The has a steeringwheel {}", steeringWheel != null);
		}
	}

}
