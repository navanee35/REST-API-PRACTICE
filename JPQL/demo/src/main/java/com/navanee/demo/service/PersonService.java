package com.navanee.demo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navanee.demo.model.Person;
import com.navanee.demo.repository.PersonRepo;



@Service
public class PersonService {
    @Autowired
    PersonRepo obj;

    public void postUser(Person person){
        obj.save(person);
    }

    public List<Person> getAllUser(){
        if(obj.count()==0){
            return Collections.emptyList();
        }
        else{

            return obj.getUsers();
        }
    }

    public List<Person> getPersonByAge(int age){
        if(obj.count()==0){
            return Collections.emptyList();
        }
        else{
            return obj.getByAge(age);
        }
    }


}