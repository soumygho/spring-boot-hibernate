package com.soumya.spring.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.soumya.spring.entity.Book;
import com.soumya.spring.entity.Chapter;
import com.soumya.spring.entity.Publisher;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class DatabaseConnectionConfig {
	private final DatabaseProperties databaseProperties;
	
	@Bean
	public BasicDataSource basicDataSource() {
		System.out.println(databaseProperties.toString());
		BasicDataSource dataSource =  new BasicDataSource();
		dataSource.setUrl(databaseProperties.getUrl());
		dataSource.setUsername(databaseProperties.getUsername());
		dataSource.setPassword(databaseProperties.getPassword());
		dataSource.setDriverClassName(databaseProperties.getDriverClassName());
		return dataSource;
	}
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(basicDataSource());
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.setAnnotatedPackages("com.soumya.spring.entity");
		sessionFactoryBean.setAnnotatedClasses(Publisher.class,Chapter.class,Book.class);
		return sessionFactoryBean;
	}
	
	@Bean
	@Primary
	public SessionFactory sessionFactory() {
		return sessionFactoryBean().getObject();
	}
	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.format_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		return hibernateProperties;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory());
		return hibernateTransactionManager;
	}
	//it is not compatible with spring 6 can use up to Spring 5 ORM
	/*@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionfactory());
		return hibernateTemplate;
	}*/
}
