package com.company.controller;

import com.company.data.StudentAuthorData;
import com.company.dto.AuthorDTO;
import com.company.dto.ResponseDTO;
import com.company.dto.StudentDTO;
import com.company.entity.Authors;
import com.company.entity.Students;
import com.company.entity.Subscriptions;
import com.company.service.SubscriptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionsService subscriptionsService;
    @PostMapping("/student/subscription")
    public ResponseEntity<ResponseDTO> addSubscription(@RequestBody StudentAuthorData userAuthorData){
        try {
            AuthorDTO authorDTO = userAuthorData.getAuthorDTO();
            StudentDTO studentDTO = userAuthorData.getStudentDTO();
            Subscriptions subscription = new Subscriptions();
            Authors author = new Authors();
            author.setAge(authorDTO.getAge());
            author.setName(authorDTO.getName());
            Students student = new Students();
            student.setAge(studentDTO.getAge());
            student.setName(studentDTO.getName());
            subscription.setAuthorsByAuthorid(author);
            subscription.setStudentsByStudentid(student);
            subscriptionsService.addSubscription(subscription);
            return ResponseEntity.ok(new ResponseDTO("success"));
        }catch (Exception ex){
            return ResponseEntity.ok(new ResponseDTO("failure"));

        }

    }
    @DeleteMapping("/student/subscription")
    public ResponseEntity<ResponseDTO> deleteSubscription(@RequestBody StudentAuthorData userAuthorData){
        try {
            AuthorDTO authorDTO = userAuthorData.getAuthorDTO();
            StudentDTO studentDTO = userAuthorData.getStudentDTO();
            Authors author = new Authors();
            author.setAge(authorDTO.getAge());
            author.setName(authorDTO.getName());
            Students student = new Students();
            student.setAge(studentDTO.getAge());
            student.setName(studentDTO.getName());
            Subscriptions subscription=subscriptionsService.getSubscription(author, student);
            subscriptionsService.removeSubscription(subscription);
            return ResponseEntity.ok(new ResponseDTO("success"));
        }catch (Exception ex){
            return ResponseEntity.ok(new ResponseDTO("failure"));

        }

    }
}
