package com.company;

import com.company.entity.Authors;
import com.company.entity.Students;
import com.company.entity.Users;
import com.company.service.AuthorService;
import com.company.service.StudentService;
import com.company.service.UserService;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class IngressDbApplication {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    AuthorService authorService;
    private static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public static void main(String[] args) {
        SpringApplication.run(IngressDbApplication.class, args);
    }
//    @Bean
//    public CommandLineRunner run() {
//        CommandLineRunner clr = new CommandLineRunner(){
//
//            @Override
//            public void run(String... args) throws Exception{
//                Users user=new Users();
//                user.setUsertype("Student");
//                user.setPasswordhash(encoder.encode("salam"));
//                user.setUsername("tamerlan.aghaev@gmail.com");
//                userService.register(user);
//
//                Students student=new Students();
//                student.setName("Tamerlan Aghayev");
//                student.setAge(19);
//                student.setUsersByUserid(user);
//                studentService.addStudent(student);
//
//
//
//            }
//        };
//
//        return clr;
//    }

}
