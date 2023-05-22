package com.roy.pranab.RestAPIDemo.dao;

import java.util.List;

import com.roy.pranab.RestAPIDemo.entity.Student;

public interface StudentDao {
    public List<Student> findAll();
    public Student findById(int id);
    public Student save(Student student);
    public void deleteById(int id);
}
