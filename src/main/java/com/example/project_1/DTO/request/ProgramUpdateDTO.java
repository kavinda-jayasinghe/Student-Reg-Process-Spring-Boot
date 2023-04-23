package com.example.project_1.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramUpdateDTO {
    private String programName;
    private String duration;
    private String cost;
}
