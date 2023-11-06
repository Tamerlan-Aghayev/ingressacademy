package com.company.repository;


import com.company.entity.Students;
import com.company.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
    @Query("select s from Students s where s.usersByUserid=:user")
    Students getStudentsByUserId(@Param("user") Users user);

    @Query("select s from Students s where s.name=:name")
    Students getSByName(@Param("name") String name);
}
