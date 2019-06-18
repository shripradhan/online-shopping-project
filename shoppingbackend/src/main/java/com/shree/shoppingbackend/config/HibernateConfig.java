package com.shree.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shree.shoppingbackend.util.SystemConstant;

/*
 * These Class alternative to Hibernate Configuration file
 * Here We are going to configure DataSource Bean , SessionFactory Bean, 
 * TransactionManagement support
 * */


@Configuration
@ComponentScan(basePackages= {"com.shree.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	@Bean
	public DataSource getDataSource() {
		//provide the database connection information
		BasicDataSource objBasicDataSource = new BasicDataSource();
		objBasicDataSource.setDriverClassName(SystemConstant.DATABASE_DRIVER);
		objBasicDataSource.setUrl(SystemConstant.DATABASE_URL);
		objBasicDataSource.setUsername(SystemConstant.DATABASE_USERNAME);
		objBasicDataSource.setPassword(SystemConstant.DATABASE_PASSWORD);
		
		return objBasicDataSource;
	}
	
	//SessionFactory Bean Available here
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		System.out.println(dataSource.getClass());
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		//set hibernate properties
		builder.addProperties(getHibernateProperties());
		//scane entity packages
		builder.scanPackages("com.shree.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}

	//configure hibernate properties and return Properties object with hibernate properties
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		
		props.put("hibernate.dialect", SystemConstant.DATABASE_DIALECT);
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "false");
		
		return props;
	}
	
	//TransactionManager bean
	@Bean
	public  HibernateTransactionManager getHibernateTransactionManager(SessionFactory factory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(factory);
		
		return transactionManager;
	}
}
