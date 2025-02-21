package com.navanee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.navanee.demo.model.Children;


@Repository
public interface ChildrenRepo extends JpaRepository<Children,Integer>{
}
