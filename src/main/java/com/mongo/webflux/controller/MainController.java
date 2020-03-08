package com.mongo.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.webflux.document.BasicDoc;
import com.mongo.webflux.service.BasicService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/webflux")
public class MainController {

	private final BasicService basicService;
	
	public MainController(BasicService basicService) {
		this.basicService = basicService;
	}

	@GetMapping
	public Flux<BasicDoc> findByTitle(){
		return basicService.findByTitle("jay");
	}
}
