package com.bd.dipti.restapi.service;

import com.bd.dipti.restapi.model.Student;
import com.bd.dipti.restapi.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student saveStudent(Student s){

        return studentRepo.save(s);
    }
    public List<Student>allStudent(){
        return studentRepo.findAll();
    }
}
