package com.example.project_1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramDTO {
    private int programId;
    private String programName;
    private String duration;
    private String cost;
}
