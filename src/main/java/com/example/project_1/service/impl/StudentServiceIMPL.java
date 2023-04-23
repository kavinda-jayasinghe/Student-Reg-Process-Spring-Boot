package com.example.project_1.service.impl;

import com.example.project_1.DTO.StudentDTO;
import com.example.project_1.DTO.paginated.PaginatedProgramDTO;
import com.example.project_1.DTO.request.StudentSaveDTO;
import com.example.project_1.DTO.request.StudentUpdateDTO;
import com.example.project_1.entity.Student;
import com.example.project_1.repo.StudentRepo;
import com.example.project_1.service.StudentService;
import com.example.project_1.util.mappers.StudentMapper;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentServiceIMPL implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentMapper studentMapper;

    //Student save
    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {
        Student student = new Student(

                studentSaveDTO.getStudentName(),
                studentSaveDTO.getStudentAddress(),
                studentSaveDTO.getContact()
        );
        if (!studentRepo.existsById(student.getStudentId())){
            studentRepo.save(student);
            return student.getCustomerName() + " saved";
        } else {
            return "Student id already exists";
        }
    }

    //get all programs using paginated
    @Override
    public PaginatedProgramDTO getAllstudents(int page, int size) {
        Page<Student> getAllProgram=studentRepo.findAll(PageRequest.of(page,size));
        return new PaginatedProgramDTO(
                studentMapper.pageToList(getAllProgram),
                studentRepo.count()
        );

    }
    //==========student update


    @Override
    public String studentUpdate(StudentUpdateDTO studentUpdateDTO, int id) {
        if(studentRepo.existsById(id)){
            studentRepo.updateCustomerByQuery(studentUpdateDTO.getStudnetName(),studentUpdateDTO.getStudentAddress(),studentUpdateDTO.getContact(),id);
            return "student has updated who has id : "+ id;
        }else {
            return "student does not excist in this id...";
        }

    }


//student delete
    @Override
    public boolean studentDelete(int id) throws NotFoundException {
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return true;
        }else{
            throw new NotFoundException("not found customer for this id");
        }


    }
//search by student id
    @Override
    public StudentDTO studentGetbyId(int id) throws NotFoundException {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()){
            StudentDTO customerDTO=modelMapper.map(student.get(),StudentDTO.class);
            return customerDTO;
        }
throw new com.example.project_1.exception.NotFoundException("Student does not exist for this id ");
    }

}