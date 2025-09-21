package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/users")
public class Controller {
    private final myRepository repo;

    public Controller(myRepository userRepo) {
        this.repo=userRepo;
    }
    @GetMapping
    public List<users>allUsers(){
        return repo.findAll();
    }

    @PostMapping("/add")
    public users user(@RequestBody users user){
        return repo.save(user);
    }

}
