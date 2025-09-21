package com.example.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/property")
public class propertyController {
    private final myRepository repo;
    private final pservice service;

    public propertyController(myRepository userRepo, pservice service) {
        this.repo=userRepo;
        this.service = service;
    }
    @PostMapping("/create")
    public ResponseEntity<property>createProperty(@RequestBody property property){
        property saved = service.create(property);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String>deleteProperty(@PathVariable Long Id){
        boolean deleted = service.deleteProperty(Id);
        if (deleted){
            return ResponseEntity.ok("Property deleted successfully");
        }else {
            return ResponseEntity.status(404).body("property not found");
        }
    }
}
