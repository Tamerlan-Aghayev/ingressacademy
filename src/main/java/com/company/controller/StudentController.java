package com.company.controller;

import com.company.dto.BookDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.Books;
import com.company.entity.Students;
import com.company.service.BookService;
import com.company.service.ReadingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private ReadingHistoryService readingHistoryService;
    @Autowired
    private BookService bookService;
    @GetMapping("/book/reading-history")
    public ResponseEntity<ResponseDTO> getBookHistory(BookDTO bookDTO){
        Books book=bookService.getByName(bookDTO.getName());
        List<Students> readers=readingHistoryService.getStudentsByBook(book);
        return ResponseEntity.ok(new ResponseDTO(readers, "success"));
    }
}
