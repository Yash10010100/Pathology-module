package com.example.pathology.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "testorders")
public class TestOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private Integer phoneNumber;

    private LocalDateTime orderDate;

    @OneToOne
    @JoinColumn(name = "test_result_id")
    private TestResult testResult;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test selectedTest;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TestOrder testOrder = (TestOrder) o;
        return Objects.equals(id, testOrder.id) && Objects.equals(patientName, testOrder.patientName) && Objects.equals(phoneNumber, testOrder.phoneNumber) && Objects.equals(orderDate, testOrder.orderDate) && Objects.equals(testResult, testOrder.testResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientName, phoneNumber, orderDate, testResult);
    }

    @PrePersist
    protected void onCreate(){
        this.orderDate = LocalDateTime.now();
    }


}
