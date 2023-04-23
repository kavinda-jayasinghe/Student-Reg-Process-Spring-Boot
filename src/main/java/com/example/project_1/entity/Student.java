package com.example.project_1.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name="student_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;


    @Column(name="student_name",length = 50)
    private String customerName;

    @Column(name="student_address")
    private String studentAddress;


    @Column(name = "contact")
    private String contact;

    public Student(String customerName, String studentAddress, String contact) {
        this.customerName = customerName;
        this.studentAddress = studentAddress;
        this.contact = contact;
    }
}