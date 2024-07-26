package com.example.Student.Controller;

import com.example.Student.Repo.StudentRepo;
import com.example.Student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @PostMapping("/api/students")
    public ResponseEntity<Student> saveStudents(@RequestBody Student student){
        return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);
        }

     @GetMapping("/api/getAllStudents")
    public ResponseEntity<List<Student>> getStudentDetails(){
        return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK);
        }

    @GetMapping("/api/getStudentDetails/{id}")
    public ResponseEntity<Student> getStudentbyID(@PathVariable int id){
        Optional<Student> studentOptional = studentRepo.findById(id);
        if(studentOptional.isPresent())
            return new ResponseEntity<>(studentOptional.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/updateStudentDetails/{id}")
    public ResponseEntity<Student> updateStudentbyID(@PathVariable int id,@RequestBody Student student){
        Optional<Student> studentOptional = studentRepo.findById(id);
        if(studentOptional.isPresent()) {
            studentOptional.get().setStudentAddress(student.getStudentAddress());
            studentOptional.get().setStudentEmail(student.getStudentEmail());
            studentOptional.get().setStudentName(student.getStudentName());
            return new ResponseEntity<>(studentRepo.save(studentOptional.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/deleteStudentDetails/{id}")
    public ResponseEntity<HttpStatus> deleteStudentbyID(@PathVariable int id){
        Optional<Student> studentOptional = studentRepo.findById(id);
        if(studentOptional.isPresent()) {
            studentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
