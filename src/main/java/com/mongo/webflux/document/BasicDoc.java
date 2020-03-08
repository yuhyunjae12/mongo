package com.mongo.webflux.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("chat")
@Getter
@Setter
public class BasicDoc {

	private String id;
	
	private String title;
	
	private String image;
	
}