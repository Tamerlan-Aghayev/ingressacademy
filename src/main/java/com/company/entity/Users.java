package com.company.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userid")
    private long userid;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "passwordhash")
    private String passwordhash;
    @Basic
    @Column(name = "usertype")
    private String usertype;
    @OneToMany(mappedBy = "usersByUserid")
    private List<Authors> authorsByUserid;
    @OneToMany(mappedBy = "usersByUserid")
    private List<Students> studentsByUserid;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userid == users.userid && Objects.equals(username, users.username) && Objects.equals(passwordhash, users.passwordhash) && Objects.equals(usertype, users.usertype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, passwordhash, usertype);
    }

    public List<Authors> getAuthorsByUserid() {
        return authorsByUserid;
    }

    public void setAuthorsByUserid(List<Authors> authorsByUserid) {
        this.authorsByUserid = authorsByUserid;
    }

    public List<Students> getStudentsByUserid() {
        return studentsByUserid;
    }

    public void setStudentsByUserid(List<Students> studentsByUserid) {
        this.studentsByUserid = studentsByUserid;
    }
}
