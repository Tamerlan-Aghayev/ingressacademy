package com.company.controller;

import com.company.data.AuthorBookData;
import com.company.dto.BookDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.Authors;
import com.company.entity.Books;
import com.company.entity.Notification;
import com.company.entity.Students;
import com.company.service.AuthorService;
import com.company.service.BookService;
import com.company.service.NotificationService;
import com.company.service.SubscriptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private SubscriptionsService subscriptionsService;
    @Autowired
    private NotificationService notificationService;
    @GetMapping("/books")
    public ResponseEntity<ResponseDTO> getBooks(){
        List<Books> books=bookService.getBooks();
        List<BookDTO> dtos=new ArrayList<>();
        for(Books book:books){
            dtos.add(new BookDTO(book));
        }
        return ResponseEntity.ok(new ResponseDTO(dtos, "success"));
    }
    @GetMapping("/student/books")
    public ResponseEntity<ResponseDTO> getBooksByStudents(@RequestBody Students student){
        List<Books> books=bookService.getBooksByStudent(student);
        List<BookDTO> dtos=new ArrayList<>();
        for(Books book:books){
            dtos.add(new BookDTO(book));
        }
        return ResponseEntity.ok(new ResponseDTO(dtos, "success"));
    }
    @GetMapping("/book")
    public ResponseEntity<ResponseDTO> getBookByName(@RequestParam("book_name") String name){
        BookDTO dto=new BookDTO(bookService.getByName(name));
        return ResponseEntity.ok(new ResponseDTO(dto, "success"));
    }
    @PostMapping("/book")
    public ResponseEntity<ResponseDTO> addBook(@RequestBody AuthorBookData dto){
        try{
            BookDTO bookDTO=dto.getBookDTO();
            Books book=new Books();
            book.setName(bookDTO.getName());
            Authors author=authorService.getAuthorByName(dto.getAuthorDTO().getName());
            book.setAuthorsByAuthorid(author);
            bookService.addBook(book);
            List<Students> students=subscriptionsService.getStudentsByAuthor(author);
            List<Notification> notificationList=new ArrayList<>();
            for(Students student:students){
                Notification notification=new Notification();
                notification.setMessage("Hey, "+ author.getName()+" published a book");
                Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
                notification.setSendDate(currentTimestamp);
                notification.setStudentsByStudentid(student);
                notification.setAuthorsByAuthorid(author);
                notificationList.add(notification);
            }
            notificationService.addNotifications(notificationList);
            return ResponseEntity.ok(new ResponseDTO("success"));
        }catch (Exception ex){
            return ResponseEntity.ok(new ResponseDTO("error"));
        }
    }
    @DeleteMapping ("/book")
    public ResponseEntity<ResponseDTO> deleteBook(@RequestBody AuthorBookData dto){
        try{
            Authors author=authorService.getAuthorByName(dto.getAuthorDTO().getName());

            Books book=bookService.getBooksByNameAndAuthor(dto.getBookDTO().getName(), author);

            bookService.deleteBook(book);
            return ResponseEntity.ok(new ResponseDTO("success"));
        }catch (Exception ex){
            return ResponseEntity.ok(new ResponseDTO("error"));
        }
    }
}
