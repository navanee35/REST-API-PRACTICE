package com.navanee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.navanee.demo.model.Message;



@Repository
public interface MessageRepo extends JpaRepository<Message,Integer>{

}
