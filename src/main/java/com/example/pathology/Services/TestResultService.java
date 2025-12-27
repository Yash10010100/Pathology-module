package com.example.pathology.Services;

import com.example.pathology.entities.TestResult;
import com.example.pathology.entities.TestResultDto;
import com.example.pathology.repos.TestResultRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestResultService {
    private final TestResultRepo testResultRepo;

    public TestResult getResultById(UUID id){
        return testResultRepo.getReferenceById(id);
    }

    public TestResult createResult(TestResultDto testResultDto){
        TestResult testResult = TestResult.builder()
                .resultValue(testResultDto.getResultValue())
                .technicianNotes(testResultDto.getTechnicianNotes())
                .build();

        return testResultRepo.save(testResult);
    }
}
