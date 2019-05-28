package com.devs4j.core.autowiring.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class TestMessageSource {
	@Autowired
	private MessageSource messageSource;

	private static final Logger log = LoggerFactory.getLogger(TestMessageSource.class);

	public void test() {
		log.info("Message source is null {}", (messageSource == null));
	}
}
