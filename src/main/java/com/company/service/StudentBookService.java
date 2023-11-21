package com.company.service;

import com.company.entity.Books;
import com.company.entity.Readinghistory;
import com.company.entity.Studentbook;
import com.company.entity.Students;
import com.company.repository.StudentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentBookService {
    @Autowired
    private StudentBookRepository studentBookRepository;
    public void addReading(Students student, Books book){
        Studentbook studentbook=new Studentbook();
        studentbook.setStudentsByStudentid(student);
        studentbook.setBooksByBookid(book);
        studentBookRepository.saveAndFlush(studentbook);
    }
    public void deleteReading(Students student, Books book){

        studentBookRepository.delete(getReading(student,book));
    }
    public Studentbook getReading(Students student, Books book){

        return studentBookRepository.getStudentBook(book, student);
    }
    public List<Students> getReaders(Books book){
        return studentBookRepository.getCurrentReaders(book);
    }
}
