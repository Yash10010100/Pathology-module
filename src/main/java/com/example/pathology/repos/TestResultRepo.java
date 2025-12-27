package com.example.pathology.repos;

import com.example.pathology.entities.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TestResultRepo extends JpaRepository<TestResult, UUID> {
}
