package com.example.project_1.controller;

import com.example.project_1.DTO.RegisterDTO;
import com.example.project_1.service.RegisterService;
import com.example.project_1.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;
    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> studentReg(@RequestBody RegisterDTO registerDTO){
        String name= registerService.registerStudent(registerDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"student successfully registered",name),
                HttpStatus.CREATED
        );
    }
}
