package com.example.project_1.repo;

import com.example.project_1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@EnableJpaRepositories
public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Modifying
    @Query(value = "update student set student_name=?1,student_address=?2,contact=?3 where student_id=?4",nativeQuery = true)
    void updateCustomerByQuery(String studnetName, String studentAddress, String contact, int id);
}
