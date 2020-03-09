package com.mongo.webflux.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.mongo.webflux.document.BasicDoc;

import reactor.core.publisher.Flux;


public interface BasicRepository extends ReactiveCrudRepository<BasicDoc, String>{

} 