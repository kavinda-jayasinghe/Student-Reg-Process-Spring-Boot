package com.example.project_1.service;

import com.example.project_1.DTO.ProgramDTO;
import com.example.project_1.DTO.StudentDTO;
import com.example.project_1.DTO.paginated.PaginatedProgramDTO;
import com.example.project_1.DTO.request.ProgramSaveDTO;
import com.example.project_1.DTO.request.ProgramUpdateDTO;
import javassist.NotFoundException;

public interface ProgramService {
    String addProgram(ProgramSaveDTO programSaveDTO);

    PaginatedProgramDTO getAllprogram(int page, int size);

    String programUpdate(ProgramUpdateDTO programUpdateDTO, int id);

    boolean programDelete(int id) throws NotFoundException;


    ProgramDTO programGetbyId(int id);
}
