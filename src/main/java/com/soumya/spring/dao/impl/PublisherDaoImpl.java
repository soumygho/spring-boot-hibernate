package com.soumya.spring.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.soumya.spring.dao.PublisherDao;
import com.soumya.spring.entity.Publisher;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
@Transactional
public class PublisherDaoImpl implements PublisherDao {
	private final SessionFactory sessionFactory;
	
	@PostConstruct
	public void postConstruct() {
	}
	@Override
	public Optional<List<Publisher>> listAll() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public void create() {
		Publisher publisher = Publisher
				.builder()
				.code("Test")
				.publisher("test")
				.build();
		sessionFactory.getCurrentSession().save(publisher);
		List<Publisher> publishers = sessionFactory
				.getCurrentSession()
				.createQuery("Select p FROM Publisher p", Publisher.class)
				.getResultList();
		publishers.forEach(System.out::println);
		
	}

}
