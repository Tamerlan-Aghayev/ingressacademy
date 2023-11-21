package com.company.repository;

import com.company.entity.Books;
import com.company.entity.Studentbook;
import com.company.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentBookRepository extends JpaRepository<Studentbook, Long> {
    @Query("select s.studentsByStudentid from Studentbook s where s.booksByBookid=:book")
    List<Students>getCurrentReaders(@Param("book") Books book);
    @Query("select s from Studentbook s where s.booksByBookid=:book and s.studentsByStudentid=:student")
    Studentbook getStudentBook(@Param("book") Books book, @Param("student") Students student);
}
