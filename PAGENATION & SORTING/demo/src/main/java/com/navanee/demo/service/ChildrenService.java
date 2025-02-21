package com.navanee.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.navanee.demo.model.Children;
import com.navanee.demo.repository.ChildrenRepo;



@Service
public class ChildrenService {
    @Autowired
    ChildrenRepo repo;

    public Children post(Children c)
    {
        return repo.save(c);
    }

    public List<Children> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return repo.findAll(sort);
    }

    public List<Children> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return repo.findAll(page).getContent();
    }
   
    public List<Children> pagesort(int pageSize,int pageNumber,String field)
    {
        return repo.findAll(PageRequest.of(pageNumber, pageSize).
        withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
   
}