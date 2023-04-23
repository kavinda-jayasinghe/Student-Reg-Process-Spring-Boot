package com.example.project_1.DTO.paginated;

import com.example.project_1.DTO.ProgramDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedProgramDTO {
    private List<ProgramDTO> list;
    private long dataCount;

}
