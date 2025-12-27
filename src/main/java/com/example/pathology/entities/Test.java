package com.example.pathology.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String sampleType;

    @Column(nullable = false)
    private String resultRange;

    @Column(nullable = false)
    private Double price;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(id, test.id) && Objects.equals(name, test.name) && Objects.equals(code, test.code) && Objects.equals(sampleType, test.sampleType) && Objects.equals(resultRange, test.resultRange) && Objects.equals(price, test.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, sampleType, resultRange, price);
    }
}
