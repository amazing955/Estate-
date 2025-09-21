package com.example.demo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class pservice {
    private final propertyrepo repository;

    public pservice(propertyrepo repository) {
        this.repository = repository;
    }


    //create
    public property create(property property){
        return repository.save(property);
    }
    //delete
    public boolean deleteProperty(Long Id){
        Optional<property>property = repository.findById(Id);
        if (property.isPresent()){
            repository.deleteById(Id);
            return true;
        }
        return false;
    }
}
