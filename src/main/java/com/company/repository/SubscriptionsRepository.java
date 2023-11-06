package com.company.repository;


import com.company.entity.Authors;
import com.company.entity.Students;
import com.company.entity.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Integer> {
    @Query("select s.studentsByStudentid from Subscriptions s where s.authorsByAuthorid=:author")
    List<Students> getStudentsByAuthors(@Param("author")Authors author);
    @Query("select s from Subscriptions s where s.authorsByAuthorid=:author and s.studentsByStudentid=:student")
    Subscriptions getByStudentAndAuthor(@Param("author")Authors author, @Param("student") Students students);
}
