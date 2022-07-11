package com.vitor.boothateoas.boothateoas.domain;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greet extends RepresentationModel<Greet> {
    private String content;

    @JsonCreator
    public Greet(@JsonProperty("content") String content) {
        this.content = content;
    }
    
    public String getContent() {
		return content;
	}
}
