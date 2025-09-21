package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface myRepository extends JpaRepository<users, Long> {
Optional<users> findByUsername(String username);
}
