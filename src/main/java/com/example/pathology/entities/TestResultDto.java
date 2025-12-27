package com.example.pathology.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestResultDto {

    private String resultValue;
    private String technicianNotes;
    private UUID forOrderId;
}
