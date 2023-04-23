package com.example.project_1.repo;

import com.example.project_1.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@EnableJpaRepositories
public interface RegisterRepo extends JpaRepository<Registration,Integer> {
}
