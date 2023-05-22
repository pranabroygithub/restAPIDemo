package com.roy.pranab.RestAPIDemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.roy.pranab.RestAPIDemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDaoImpl implements StudentDao{

    private EntityManager entityManager;

    StudentDaoImpl (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> result = entityManager.createQuery("FROM Student", Student.class);
        return result.getResultList();
    } 

    @Override
    public Student findById(int id) {
        Student student = entityManager.find(Student.class,id);
        return student;
    }

    @Override
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }
    
}
