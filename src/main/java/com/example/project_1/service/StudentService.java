package com.example.project_1.service;


import com.example.project_1.DTO.StudentDTO;
import com.example.project_1.DTO.paginated.PaginatedProgramDTO;
import com.example.project_1.DTO.request.StudentSaveDTO;
import com.example.project_1.DTO.request.StudentUpdateDTO;
import javassist.NotFoundException;


public interface StudentService {


    String addStudent(StudentSaveDTO studentSaveDTO);

    String studentUpdate(StudentUpdateDTO studentUpdateDTO ,int id);

    boolean studentDelete(int id) throws NotFoundException;

    StudentDTO studentGetbyId(int id) throws NotFoundException;

    PaginatedProgramDTO getAllstudents(int page, int size);
}
