package com.example.pathology.Services;

import com.example.pathology.entities.Test;
import com.example.pathology.entities.TestOrder;
import com.example.pathology.entities.TestOrderDto;
import com.example.pathology.repos.TestOrderRepo;
import com.example.pathology.repos.TestRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestOrderService {

    private final TestOrderRepo testOrderRepo;
    private final TestRepo testRepo;

    public TestOrder getOrderById(UUID id){
        return testOrderRepo.getReferenceById(id);
    }

    public List<TestOrder> getAllOrders(){
        return testOrderRepo.findAll();
    }

    @Transactional
    public TestOrder createOrder(TestOrderDto testOrderDto){

        Test test = testRepo.getReferenceById(testOrderDto.getSelectedTest());

        TestOrder testOrder = TestOrder.builder()
                .patientName(testOrderDto.getPatientName())
                .phoneNumber(testOrderDto.getPhoneNumber())
                .selectedTest(test)
                .build();

        return testOrderRepo.save(testOrder);
    }
}
