package com.example.project_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="registration")
public class Registration {

    @Id
    @Column(name="student_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String programId;

    @Column(name = "date")
    private String date;

    public Registration(String date) {
        this.date = date;
    }
}
