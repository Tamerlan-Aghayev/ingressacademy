package com.company.repository;


import com.company.entity.Books;
import com.company.entity.Readinghistory;
import com.company.entity.Students;
import com.company.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingHistoryRepository extends JpaRepository<Readinghistory, Integer> {
    @Query("SELECT DISTINCT s FROM Students s JOIN s.readinghistoriesByStudentid rh JOIN rh.booksByBookid b WHERE b = :book")
    List<Students> getStudentsByBook(@Param("book") Books book);

}
