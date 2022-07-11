package com.vitor.boothateoas.boothateoas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitor.boothateoas.boothateoas.domain.Greet;

@RestController
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s!";

	@RequestMapping("/greeting")
	public HttpEntity<Greet> greeting(
		@RequestParam(value = "name", defaultValue = "World") String name) {

		Greet greet = new Greet(String.format(TEMPLATE, name));
		greet.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

		return new ResponseEntity<>(greet, HttpStatus.OK);
	}
}