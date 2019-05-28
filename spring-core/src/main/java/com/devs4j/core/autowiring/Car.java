package com.devs4j.core.autowiring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
class Engine {
	private static final Logger log = LoggerFactory.getLogger(Engine.class);

	public void turnOn() {
		log.info("Turning on the engine");
	}
}

class SteeringWheel {
	private static final Logger log = LoggerFactory.getLogger(SteeringWheel.class);

	public void goStraight() {
		log.info("Going straight");
	}
}

@Service
class Owner {
	private static final Logger log = LoggerFactory.getLogger(Owner.class);

	public void printOwnerName() {
		log.info("Owner name {} ", "Alex");
	}
}

@Service
public class Car {
	private Engine engine;

	private SteeringWheel steeringWheel;

	private Owner owner;

	private static final Logger log = LoggerFactory.getLogger(Car.class);

	@Autowired(required = false)
	public Car(Engine bar) {
		this.engine = bar;
	}

	@Autowired(required = false)
	public Car(SteeringWheel steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
	@Autowired(required = false)
	public Car(Owner owner) {
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
