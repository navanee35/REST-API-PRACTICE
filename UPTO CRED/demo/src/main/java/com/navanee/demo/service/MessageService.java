package com.navanee.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navanee.demo.model.Message;
import com.navanee.demo.repository.MessageRepo;

@Service
public class MessageService {

    @Autowired
    MessageRepo obj;
    public Message add(Message a)
    {
        return obj.save(a);
    }

    public List<Message> getAllMessages() {
        return obj.findAll();
    }

    public Optional<Message> getMessageById(int id) {
        return obj.findById(id);
    }

    public Message updateMessage(int id, Message newMessage) {
        return obj.findById(id).map(existingMessage -> {
            existingMessage.setFirstName(newMessage.getFirstName());
            existingMessage.setLastName(newMessage.getLastName());
            return obj.save(existingMessage);
        }).orElseThrow(() -> new RuntimeException("Message not found with id " + id));
    }

    public void deleteMessage(int id)
     {
        if (obj.existsById(id))
         {
            obj.deleteById(id);
        } 
        else 
        {
            throw new RuntimeException("Message not found with id " + id);
        }
    }
}


