package com.company.repository;

import com.company.entity.Authors;
import com.company.entity.Books;
import com.company.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
    @Query("Select b from Books b where b.name=:name")
    Books getByName(@Param("name") String name);
    @Query("Select b from Books b where b.studentsByStudentid=:student")
    List<Books> getByStudent(@Param("student") Students student);
    @Query("Select b from Books b where b.name=:name and b.authorsByAuthorid=:author")
    Books getByNameAndAuthor(@Param("name") String name, @Param("author")Authors author);


    @Query("select b.studentsByStudentid from Books b where b.name=:name")
    List<Students> getReaders(@Param("name") String name);

}
