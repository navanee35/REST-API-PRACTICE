package com.navanee.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.navanee.demo.model.Person;
import com.navanee.demo.service.PersonService;



@RestController
public class PersonController {
    @Autowired
    PersonService service;
    @PostMapping("/api/person")
    public ResponseEntity<Person> postMethod(@RequestBody Person person){
        System.out.println(person.getFirstName());
        try{
            service.postUser(person);
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/person")
    public ResponseEntity<List<Person>> getMethodName(){
        try{
            return new ResponseEntity<>(service.getAllUser(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/api/person/byAge")
    public ResponseEntity<List<Person>> getMethodName(@RequestParam int age){
        try{
            return new ResponseEntity<>(service.getPersonByAge(age), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}