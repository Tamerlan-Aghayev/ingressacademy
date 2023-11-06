package com.company.controller;

import com.company.data.UserAuthorData;
import com.company.data.UserStudentData;
import com.company.dto.AuthorDTO;
import com.company.dto.ResponseDTO;
import com.company.dto.StudentDTO;
import com.company.dto.UserDTO;
import com.company.entity.Authors;
import com.company.entity.Students;
import com.company.entity.Users;
import com.company.service.AuthorService;
import com.company.service.StudentService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginRegistrationController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorService authorService;
    private static BCryptPasswordEncoder crypt=new BCryptPasswordEncoder();
    @PostMapping("/registration/student")
    public void registerStudent(@RequestBody UserStudentData dto){
        Users user=new Users();
        UserDTO userDTO=dto.getUserDTO();
        user.setUsertype(userDTO.getUserType());
        user.setUsername(userDTO.getUsername());
        user.setPasswordhash(crypt.encode(userDTO.getPassword()));
        userService.register(user);
        Students student=new Students();
        StudentDTO studentDTO=dto.getStudentDTO();
        student.setName(studentDTO.getName());
        student.setAge(student.getAge());
        studentService.addStudent(student);
    }
    @PostMapping("/registration/author")
    public void registerUser(@RequestBody UserAuthorData dto){
        Users user=new Users();
        UserDTO userDTO=dto.getUserDTO();
        user.setUsertype(userDTO.getUserType());
        user.setUsername(userDTO.getUsername());
        user.setPasswordhash(crypt.encode(userDTO.getPassword()));
        userService.register(user);
        Authors author=new Authors();
        AuthorDTO authorDTO=dto.getAuthorDTO();
        author.setName(authorDTO.getName());
        author.setAge(authorDTO.getAge());
        authorService.addAuthor(author);
    }
    @GetMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestParam("username") String username, @RequestParam("password") String password){

        Users user= userService.getByUsernameAndPassword(username, crypt.encode(password));
        UserDTO userDTO=new UserDTO(user);
        if(user.getUsertype().equals("Student")){
            StudentDTO studentDTO =new StudentDTO(studentService.getStudentsByUserId(user));

            return ResponseEntity.ok(new ResponseDTO(new UserStudentData(userDTO,studentDTO), "success"));
        }
        else if(user.getUsertype().equals("Author")){
            AuthorDTO authorDTO=new AuthorDTO(authorService.getAuthorByUserId(user));
            return ResponseEntity.ok(new ResponseDTO(new UserAuthorData(userDTO, authorDTO), "success"));
        }
        else{
            return ResponseEntity.ok(new ResponseDTO( "success"));

        }
    }


}
