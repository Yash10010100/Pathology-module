package com.example.pathology.Services;

import com.example.pathology.entities.Test;
import com.example.pathology.entities.TestDto;
import com.example.pathology.repos.TestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepo testRepo;

    public Test getTestById(UUID id){
        return testRepo.getReferenceById(id);
    }

    public List<Test> getAllTests(){
        return testRepo.findAll();
    }

    public List<Test> getAllTestsByName(String name){
        return testRepo.findTestsByNameContainingIgnoreCase(name);
    }

    public Test createTest(TestDto testDto){
        Test newTest = Test.builder()
                .name(testDto.getName())
                .code(testDto.getCode())
                .sampleType(testDto.getSampleType())
                .resultRange(testDto.getResultRange())
                .price(testDto.getPrice())
                .build();
        return testRepo.save(newTest);
    }
}
