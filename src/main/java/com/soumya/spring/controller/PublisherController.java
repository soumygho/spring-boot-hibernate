package com.soumya.spring.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumya.spring.dao.PublisherDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/publisher")
public class PublisherController {
	private final PublisherDao publisherDao;
	
	@GetMapping
	public ResponseEntity<String> getPublisher() {
		publisherDao.create();
		return new ResponseEntity<String>("Created", HttpStatus.OK);
	}
}
