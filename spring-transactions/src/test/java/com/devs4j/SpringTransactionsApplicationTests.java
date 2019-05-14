package com.devs4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devs4j.config.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestConfiguration.class})
public class SpringTransactionsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
