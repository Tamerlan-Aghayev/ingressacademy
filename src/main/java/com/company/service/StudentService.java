package com.company.service;

import com.company.entity.Students;
import com.company.entity.Users;
import com.company.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public void addStudent(Students student){
        studentRepository.saveAndFlush(student);
    }
    public Students getStudentsByUserId(Users user){
        return studentRepository.getStudentsByUserId(user);
    }


}
