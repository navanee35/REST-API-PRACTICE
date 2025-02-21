package com.navanee.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navanee.demo.model.Message;


@RestController
public class MyResponse {

    @GetMapping("/jsonproof")
    public Message abc(){
        return new Message(1, "Navaneetha", "Priyan");
    }

}
