package com.example.project_1.util.mappers;

import com.example.project_1.DTO.ProgramDTO;
import com.example.project_1.entity.Student;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    List<ProgramDTO> pageToList(Page<Student> page);
}
