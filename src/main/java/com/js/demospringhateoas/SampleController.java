package com.js.demospringhateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SampleController {
    @GetMapping("/hello")
    public EntityModel<Hello> hello() {
        Hello hello = new Hello();
        hello.setName("junseong");
        hello.setPrefix("hey,");

        EntityModel<Hello> helloHateoas = new EntityModel<>(hello);
        helloHateoas.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());

        return helloHateoas;
    }
}
