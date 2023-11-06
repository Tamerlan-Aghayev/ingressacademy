package com.company.service;

import com.company.entity.Authors;
import com.company.entity.Students;
import com.company.entity.Users;
import com.company.repository.AuthorRepository;
import com.company.repository.StudentRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void register(Users user){

        userRepository.saveAndFlush(user);

    }
    public Users getByUsernameAndPassword(String username, String password){
        return userRepository.getByUsernameAndPasswordHash(username, password);
    }
    public Users getByUsername(String username){
        return userRepository.getByUsername(username);
    }
}
