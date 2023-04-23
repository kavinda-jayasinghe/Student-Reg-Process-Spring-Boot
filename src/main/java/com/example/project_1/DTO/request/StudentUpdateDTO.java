package com.example.project_1.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentUpdateDTO {
    private String studnetName;
    private String studentAddress;
    private String contact;
}
