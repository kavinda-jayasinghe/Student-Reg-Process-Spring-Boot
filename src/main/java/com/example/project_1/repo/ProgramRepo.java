package com.example.project_1.repo;

import com.example.project_1.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@EnableJpaRepositories
public interface ProgramRepo extends JpaRepository<Program,Integer> {
    @Modifying
    @Query(value = "update program set program_name=?1,cost=?2,duration=?3 where program_id=?4",nativeQuery = true)
    void updateProgram(String studnetName, String studentAddress, String contact, int id);
}
