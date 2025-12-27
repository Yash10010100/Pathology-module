package com.example.pathology.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestDto {
    private String name;
    private String code;
    private String sampleType;
    private String resultRange;
    private Double price;
}
