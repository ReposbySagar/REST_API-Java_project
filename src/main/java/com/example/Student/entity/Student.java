package com.example.Student.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String studentName;
    private String studentEmail;
    private String studentAddress;

    public Student(int id, String studentName, String studentEmail, String studentAddress) {
        this.id = id;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
    }

    public Student() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

        @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", StudentName='" + studentName + '\'' +
                ", StudentEmail='" + studentEmail + '\'' +
                ", StudentAddress='" + studentAddress + '\'' +
                '}';
    }
}
