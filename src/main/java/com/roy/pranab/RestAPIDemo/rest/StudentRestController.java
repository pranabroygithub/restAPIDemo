package com.roy.pranab.RestAPIDemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roy.pranab.RestAPIDemo.entity.Student;
import com.roy.pranab.RestAPIDemo.service.StudentServiceDaoImpl;


@RestController
@RequestMapping("/api")
public class StudentRestController {
    
    private StudentServiceDaoImpl studentServiceDaoImpl;

    StudentRestController(StudentServiceDaoImpl studentServiceDaoImpl){
        this.studentServiceDaoImpl = studentServiceDaoImpl;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return this.studentServiceDaoImpl.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getAStudentById(@PathVariable("studentId") int studentId){
        Student student =  this.studentServiceDaoImpl.findById(studentId);
        if(student == null)
            throw new RuntimeException("student not found with id " + studentId);
        return student;    
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        student.setId(0);
        return this.studentServiceDaoImpl.save(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        Student std = studentServiceDaoImpl.findById(student.getId());
        if(std == null)
            throw new RuntimeException("student not found with id " + student.getId());
        return this.studentServiceDaoImpl.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable("studentId") int studentId){
        Student std = studentServiceDaoImpl.findById(studentId);
        if(std == null)
            throw new RuntimeException("student not found with id " + studentId);
        this.studentServiceDaoImpl.deleteById(studentId);
        return "student deleted with id "+ studentId;
    }
}
