package com.company.repository;

import com.company.entity.Books;
import com.company.entity.Readinghistory;
import com.company.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReadingHistoryRepository extends JpaRepository<Readinghistory, Long> {
    @Query("Select r.studentsByStudentid from Readinghistory r where r.booksByBookid=:book")
    List<Students> getReadingHistory(@Param("book")Books book);
}
