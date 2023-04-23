package com.example.project_1.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentSaveDTO {

        private String studentName;
        private String studentAddress;
        private String contact;
    }
