package com.mongo.webflux.controller;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.webflux.document.BasicDoc;
import com.mongo.webflux.document.BasicDocEvent;
import com.mongo.webflux.service.BasicService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping(value = "/webflux")
public class MainController {

	private final BasicService basicService;
	
	public MainController(BasicService basicService) {
		this.basicService = basicService;
	}

	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<BasicDocEvent> sse(){
		return basicService.findAllDoc().flatMap(basicDoc -> {
			Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
			Flux<BasicDocEvent> basicDocEvent = Flux.fromStream(Stream.generate(() -> new BasicDocEvent(basicDoc, new Date())));
			return Flux.zip(interval, basicDocEvent)
                    .map(Tuple2::getT2);
		});
	}
	
//	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//	public Flux<BasicDoc> sse(){
//		return basicService.findAllDoc().publishOn(Schedulers.parallel()).log().delayElements(Duration.ofSeconds(1));
//	}
	
	@PostMapping
	public Mono<BasicDoc> saveDoc(@RequestBody BasicDoc doc){
		return basicService.save(doc);
	}
	
}
