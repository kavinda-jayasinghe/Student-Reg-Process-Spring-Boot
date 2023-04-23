package com.example.project_1.service.impl;

import com.example.project_1.DTO.ProgramDTO;
import com.example.project_1.DTO.StudentDTO;
import com.example.project_1.DTO.paginated.PaginatedProgramDTO;
import com.example.project_1.DTO.request.ProgramSaveDTO;

import com.example.project_1.DTO.request.ProgramUpdateDTO;
import com.example.project_1.DTO.request.StudentUpdateDTO;
import com.example.project_1.entity.Program;
import com.example.project_1.entity.Student;
import com.example.project_1.repo.ProgramRepo;

import com.example.project_1.service.ProgramService;
import com.example.project_1.util.mappers.ProgramMapper;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramServiceIMPL implements ProgramService {
    @Autowired
    private ProgramRepo programRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProgramMapper programMapper;

    //save
    @Override
    public String addProgram(ProgramSaveDTO programSaveDTO) {
        Program program = new Program(

                programSaveDTO.getProgramName(),
                programSaveDTO.getDuration(),
                programSaveDTO.getCost()
        );

        if (!programRepo.existsById(program.getProgramId())){

            programRepo.save(program);
            return program.getProgramName() + " saved";
        } else {
            return "program id already exists";
        }
    }

//get all programs using paginated
    @Override
    public PaginatedProgramDTO getAllprogram(int page, int size) {
        Page<Program> getAllProgram=programRepo.findAll(PageRequest.of(page,size));
        return new PaginatedProgramDTO(
programMapper.pageToList(getAllProgram),
                programRepo.count()
        );

}

//update
    @Override
    public String programUpdate(ProgramUpdateDTO programUpdateDTO, int id) {
        if(programRepo.existsById(id)){
            programRepo.updateProgram(programUpdateDTO.getProgramName(),programUpdateDTO.getCost(),programUpdateDTO.getDuration(),id);
            return "porogram has updated which has id : "+ id;
        }else {
            return "program does not excist in this id...";
        }

    }

//delete
    @Override
    public boolean programDelete(int id) throws NotFoundException {
        if(programRepo.existsById(id)){
            programRepo.deleteById(id);
            return true;
        }else{
            throw new NotFoundException("not found customer for this id");
        }
    }

//get by id
    @Override
    public ProgramDTO programGetbyId(int id) {
        Optional<Program> program = programRepo.findById(id);
        if(program.isPresent()){
            ProgramDTO programDTO=modelMapper.map(program.get(),ProgramDTO.class);
            return programDTO;
        }
        throw new com.example.project_1.exception.NotFoundException("Program does not exist for this id ");
    }
}


