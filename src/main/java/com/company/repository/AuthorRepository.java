package com.company.repository;

import com.company.entity.Authors;
import com.company.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Authors, Integer> {
    @Query("select a from Authors a where a.usersByUserid=:user")
    Authors getAuthorsByUserId(@Param("user")Users user);
    @Query("select a from Authors a where a.name=:name")
    Authors getAuthorByName(@Param("name")String name);
}
