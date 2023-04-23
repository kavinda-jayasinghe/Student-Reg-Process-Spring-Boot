package com.example.project_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="program")
public class Program {
    @Id
    @Column(name="program_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int programId;

    @Column(name="program_name",length = 50)
    private String programName;

    @Column(name="duration")
    private String duration;


    @Column(name = "cost")
    private String cost;

    public Program(String programName, String duration, String cost) {
        this.programName = programName;
        this.duration = duration;
        this.cost = cost;
    }
}
