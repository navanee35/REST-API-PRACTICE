package com.navanee.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.navanee.demo.model.Children;
import com.navanee.demo.service.ChildrenService;



@RestController
public class ChildrenController {
    @Autowired
    ChildrenService ser;

    @PostMapping("/api/children")
    public ResponseEntity<Children> pos(@RequestBody Children c)
    {
        return  ResponseEntity.status(201).body(ser.post(c));
    }

    @GetMapping("/api/children/sortBy/{field}")
    public List<Children> g(@PathVariable String field)
    {
        return ser.sort(field);
    }

    @GetMapping("/api/children/{offset}/{pagesize}")
    public List<Children> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return ser.page(pagesize, offset);
    }

    @GetMapping("/api/children/{offset}/{pagesize}/{field}")
    public List<Children> pagesorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return ser.pagesort(pagesize,offset, field);
    }
}