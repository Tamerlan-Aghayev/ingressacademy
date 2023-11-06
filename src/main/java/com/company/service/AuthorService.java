package com.company.service;

import com.company.entity.Authors;
import com.company.entity.Users;
import com.company.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public void addAuthor(Authors author){
        authorRepository.saveAndFlush(author);
    }
    public Authors getAuthorByUserId(Users user){
        return authorRepository.getAuthorsByUserId(user);
    }
    public Authors getAuthorByName(String name){
        return authorRepository.getAuthorByName(name);
    }
}
