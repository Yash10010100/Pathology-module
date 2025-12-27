package com.example.pathology.controllers;

import com.example.pathology.Services.TestService;
import com.example.pathology.entities.Test;
import com.example.pathology.entities.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tests")
public class TestController {
    private final TestService testService;

    @GetMapping("/{id}")
    public ResponseEntity<Test> getTestById(@PathVariable UUID id){
        Test test = testService.getTestById(id);

        return ResponseEntity.ok(test);
    }

    @GetMapping
    public ResponseEntity<List<Test>> getAllTests(){
        List<Test> tests = testService.getAllTests();

        return ResponseEntity.ok(tests);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Test>> getAllTestsByName(@PathVariable String name){
        List<Test> tests = testService.getAllTestsByName(name);

        return ResponseEntity.ok(tests);
    }

    @PostMapping
    public ResponseEntity<Test> createTest(@RequestBody TestDto testDto){
        Test createdTest = testService.createTest(testDto);

        return ResponseEntity.ok(createdTest);
    }

}
