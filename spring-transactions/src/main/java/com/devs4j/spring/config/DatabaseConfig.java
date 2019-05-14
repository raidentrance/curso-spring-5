package com.devs4j.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Bean
	public DataSource datasource() {
		DriverManagerDataSource datasurce = new DriverManagerDataSource();
		datasurce.setUrl("jdbc:h2:file:~/test");
		datasurce.setUsername("sa");
		datasurce.setDriverClassName("org.h2.Driver");
		return datasurce;
	}

	/**
	 * Used to support programmatic transactions
	 * 
	 * @param datasource
	 * @return
	 */
	@Bean
	public PlatformTransactionManager dataSourceTransactionManager(DataSource datasource) {
		return new DataSourceTransactionManager(datasource);
	}

	/**
	 * Used to support programmatic transactions
	 * 
	 * @param transactionManager
	 * @return
	 */
	@Bean
	public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
		return new TransactionTemplate(transactionManager);
	}

}
