package com.example.pathology.repos;

import com.example.pathology.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TestRepo extends JpaRepository<Test, UUID> {
    List<Test> findTestsByNameContainingIgnoreCase(String name);
}
