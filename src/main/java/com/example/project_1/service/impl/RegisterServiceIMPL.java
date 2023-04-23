package com.example.project_1.service.impl;

import com.example.project_1.DTO.RegisterDTO;
import com.example.project_1.entity.Registration;

import com.example.project_1.repo.RegisterRepo;
import com.example.project_1.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceIMPL implements RegisterService {
    @Autowired
    private RegisterRepo registerRepo;

    @Override
    public String registerStudent(RegisterDTO registerDTO) {
        Registration student = new Registration(

                registerDTO.getRegisterDate()
        );
        if (!registerRepo.existsById(student.getStudentId())){
            registerRepo.save(student);
            return  " registered..";
        } else {
            return "Register id already exists";
        }
    }
}
