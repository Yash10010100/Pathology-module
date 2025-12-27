package com.example.pathology.Services;

import com.example.pathology.entities.TestOrder;
import com.example.pathology.entities.TestOrderDto;
import com.example.pathology.repos.TestOrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestOrderService {

    private final TestOrderRepo testOrderRepo;

    public TestOrder getOrderById(UUID id){
        return testOrderRepo.getReferenceById(id);
    }

    public List<TestOrder> getAllOrders(){
        return testOrderRepo.findAll();
    }

    public TestOrder createOrder(TestOrderDto testOrderDto){
        TestOrder testOrder = TestOrder.builder()
                .patientName(testOrderDto.getPatientName())
                .phoneNumber(testOrderDto.getPhoneNumber())
                .build();

        return testOrderRepo.save(testOrder);
    }
}
