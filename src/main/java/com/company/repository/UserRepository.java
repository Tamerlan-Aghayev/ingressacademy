package com.company.repository;

import com.company.entity.Authors;
import com.company.entity.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query("Select u from Users u where u.username=:username and u.passwordhash=:password")
    Users getByUsernameAndPasswordHash(@Param("username") String username, @Param("password") String password);
    @Query("Select u from Users u where u.username=:username")
    Users getByUsername(@Param("username") String username);
}
