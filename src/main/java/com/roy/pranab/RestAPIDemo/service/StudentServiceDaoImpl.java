package com.roy.pranab.RestAPIDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roy.pranab.RestAPIDemo.dao.StudentDaoImpl;
import com.roy.pranab.RestAPIDemo.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceDaoImpl implements StudentServiceDao{

    private StudentDaoImpl stundentDaoImpl;

    StudentServiceDaoImpl(StudentDaoImpl studentDaoImpl){
        this.stundentDaoImpl = studentDaoImpl;
    }

    @Override
    public List<Student> findAll() {
        return this.stundentDaoImpl.findAll();
    }

    @Override
    public Student findById(int id) {
        return this.stundentDaoImpl.findById(id);
    }


    @Override
    @Transactional
    public Student save(Student student) {
        return this.stundentDaoImpl.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        this.stundentDaoImpl.deleteById(id);
    }

}