package com.example.project_1.controller;

import com.example.project_1.DTO.ProgramDTO;
import com.example.project_1.DTO.paginated.PaginatedProgramDTO;
import com.example.project_1.DTO.request.ProgramSaveDTO;
import com.example.project_1.DTO.request.ProgramUpdateDTO;
import com.example.project_1.service.ProgramService;
import com.example.project_1.util.StandardResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@CrossOrigin
@RequestMapping("api/v1/program")
public class ProgramController {
@Autowired
private ProgramService programService;

//save
    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> studentSave(@RequestBody ProgramSaveDTO programSaveDTO){
        String id= programService.addProgram(programSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+"Programm successfully saved",id),
                HttpStatus.CREATED
        );
    }

    //get all
    @GetMapping(path="get-all-program",
            params={"page","size"}
    )
    public ResponseEntity<StandardResponse> getAllPrograms(
            @RequestParam(value="page") int page,
            @RequestParam(value="size") @Max(50) int size
    )
    {
        PaginatedProgramDTO paginatedProgramDTO=programService.getAllprogram(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success ",paginatedProgramDTO),
                HttpStatus.OK
        );
    }

    //update student

    @PutMapping(path={"/update/{id}"})

    public ResponseEntity<StandardResponse> updateProgram(
            @RequestBody ProgramUpdateDTO programUpdateDTO,
            @PathVariable(value = "id") int id){
        String updated=programService.programUpdate(programUpdateDTO,id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+"Programm successfully saved",updated),
                HttpStatus.CREATED
        );
    }




    //delete student
    @DeleteMapping(
            path={"/delete-program/{id}"}
    )
    public String deleteProgram( @PathVariable(value = "id") int id) throws NotFoundException {

        boolean program=programService.programDelete(id);
        return "deleted";
    }



    //get program by id
    @GetMapping(path={"/get-by-id"},params="id")

    public ProgramDTO getProgramByid(@RequestParam(value="id") int id) throws NotFoundException {
        ProgramDTO programDTO=programService.programGetbyId(id);
        return programDTO;
    }
}
