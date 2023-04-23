package com.example.project_1.controller;

import com.example.project_1.DTO.StudentDTO;
import com.example.project_1.DTO.paginated.PaginatedProgramDTO;
import com.example.project_1.DTO.request.StudentSaveDTO;
import com.example.project_1.DTO.request.StudentUpdateDTO;
import com.example.project_1.service.StudentService;
import com.example.project_1.util.StandardResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;


@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    //save student

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> studentSave(@RequestBody StudentSaveDTO studentSaveDTO){
        String name= studentService.addStudent(studentSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"student successfully saved",name),
                HttpStatus.CREATED
        );
    }

    //get all
    @GetMapping(path="get-all-student",
            params={"page","size"}
    )
    public ResponseEntity<StandardResponse> getAllStudents(
            @RequestParam(value="page") int page,
            @RequestParam(value="size") @Max(50) int size
    )
    {
        PaginatedProgramDTO paginatedProgramDTO=studentService.getAllstudents(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success ",paginatedProgramDTO),
                HttpStatus.OK
        );
    }

    //update student

    @PutMapping(path={"/update/{id}"})

    public ResponseEntity<StandardResponse> updateStudent(
            @RequestBody StudentUpdateDTO studentUpdateDTO,
            @PathVariable(value = "id") int id){
        String updated=studentService.studentUpdate(studentUpdateDTO,id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+"Programm successfully saved",updated),
                HttpStatus.CREATED
        );
    }

    //delete student
    @DeleteMapping(
            path={"/delete-student/{id}"}
    )
    public String deleteStudent( @PathVariable(value = "id") int id) throws NotFoundException {

        boolean student=studentService.studentDelete(id);
        return "deleted";
    }

//get student by id
    @GetMapping(path={"/get-by-id"},params="id")

    public StudentDTO getStudentByid(@RequestParam(value="id") int id) throws NotFoundException {
        StudentDTO studentDTO=studentService.studentGetbyId(id);
        return studentDTO;
    }


}
