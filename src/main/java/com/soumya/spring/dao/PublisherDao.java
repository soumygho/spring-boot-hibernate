package com.soumya.spring.dao;

import java.util.List;
import java.util.Optional;

import com.soumya.spring.entity.Publisher;

public interface PublisherDao {
	Optional<List<Publisher>> listAll();
	
	void create();
}
