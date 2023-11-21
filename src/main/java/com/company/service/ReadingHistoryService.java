package com.company.service;

import com.company.entity.Books;
import com.company.entity.Readinghistory;
import com.company.entity.Students;
import com.company.repository.ReadingHistoryRepository;
import liquibase.pro.packaged.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReadingHistoryService {
    @Autowired
    ReadingHistoryRepository readingHistoryRepository;
    public List<Students> getHistory(Books book){
        return readingHistoryRepository.getReadingHistory(book);
    }
    public void addHistory(Readinghistory readinghistory){
        readingHistoryRepository.saveAndFlush(readinghistory);
    }
}
