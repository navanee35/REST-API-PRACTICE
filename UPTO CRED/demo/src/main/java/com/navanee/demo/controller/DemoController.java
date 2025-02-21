package com.navanee.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {

    @GetMapping("/s1")
    public String Sample1() {
        return "Hello, World!";
    }

    @GetMapping("/s2")
    public String Sample2(@RequestParam String Name, @RequestParam int age)
    {
        return "Hello, " + Name + " and your age is " + age + ". Right?";
    }
    @GetMapping("/abcd")
    public String getStudentName(@RequestParam String studentname,@RequestParam int studentage)
    {
        return "GOOD MORNING"+studentname+studentage ;
    }
    @GetMapping("/{studentname}")
    public String getstudentname(@PathVariable String studentname)
    {
        return "welcome " + studentname;
    }
}