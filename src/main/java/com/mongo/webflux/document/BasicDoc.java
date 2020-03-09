package com.mongo.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("basic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasicDoc {

	@Id
	private Long id;	
	private String title;
	
}