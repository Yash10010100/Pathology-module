package com.example.pathology.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "testresults")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String resultValue;

    private String technicianNotes;

    @OneToOne
    @JoinColumn(name = "test_order_id", nullable = false, unique = true)
    private TestOrder forOrderId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TestResult that = (TestResult) o;
        return Objects.equals(id, that.id) && Objects.equals(resultValue, that.resultValue) && Objects.equals(technicianNotes, that.technicianNotes) && Objects.equals(forOrderId, that.forOrderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resultValue, technicianNotes, forOrderId);
    }
}
