package com.mongo.webflux.service;

import org.springframework.stereotype.Service;

import com.mongo.webflux.document.BasicDoc;
import com.mongo.webflux.repository.BasicRepository;

import reactor.core.publisher.Flux;

@Service
public class BasicService {

	private BasicRepository basicRepository;
	
	public BasicService(BasicRepository basicRepository) {
		this.basicRepository = basicRepository;
	}

	
	public Flux<BasicDoc> findByTitle(String title){
		return basicRepository.findByTitle(title);
	}
	
}
