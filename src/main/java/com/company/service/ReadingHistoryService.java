package com.company.service;

import com.company.entity.Books;
import com.company.entity.Readinghistory;
import com.company.entity.Students;
import com.company.entity.Users;
import com.company.repository.BookRepository;
import com.company.repository.ReadingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReadingHistoryService {
    @Autowired
    private ReadingHistoryRepository readingHistoryRepository;
    public List<Students> getStudentsByBook(Books book){
        return readingHistoryRepository.getStudentsByBook(book);
    }
}

