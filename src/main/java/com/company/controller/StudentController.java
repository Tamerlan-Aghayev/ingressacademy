package com.company.controller;

import com.company.dto.BookDTO;
import com.company.dto.ResponseDTO;
import com.company.dto.StudentDTO;
import com.company.entity.Books;
import com.company.entity.Students;
import com.company.repository.StudentRepository;
import com.company.service.BookService;
import com.company.service.ReadingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ReadingHistoryService readingHistoryService;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/book/reading-history")
    public ResponseEntity<ResponseDTO> getBookHistory(BookDTO bookDTO){
        Books book=bookService.getByName(bookDTO.getName());
        List<Students> readers=readingHistoryService.getHistory(book);
        List<StudentDTO> dtoReaders= readers.stream().map((reader)->new StudentDTO(reader)).collect(Collectors.toList());
        return ResponseEntity.ok(new ResponseDTO(dtoReaders, "success"));
    }
}
