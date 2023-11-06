package com.company.service;

import com.company.entity.Authors;
import com.company.entity.Books;
import com.company.entity.Students;
import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Books> getBooks(){
        return bookRepository.findAll();
    }
    public Books getByName(String name){
        return bookRepository.getByName(name);
    }
    public void addBook(Books book){
        bookRepository.saveAndFlush(book);
    }
    public void deleteBook(Books book){
        bookRepository.delete(book);
    }
    public List<Books> getBooksByStudent(Students student){
        return bookRepository.getByStudent(student);
    }
    public Books getBooksByNameAndAuthor(String name, Authors author){
        return bookRepository.getByNameAndAuthor(name, author);
    }
}
