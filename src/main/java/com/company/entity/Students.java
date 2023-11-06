package com.company.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Students {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "studentid")
    private long studentid;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "studentsByStudentid")
    private List<Books> booksByStudentid;
    @OneToMany(mappedBy = "studentsByStudentid")
    private List<Notification> notificationsByStudentid;
    @OneToMany(mappedBy = "studentsByStudentid")
    private List<Readinghistory> readinghistoriesByStudentid;
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Users usersByUserid;
    @OneToMany(mappedBy = "studentsByStudentid")
    private List<Subscriptions> subscriptionsByStudentid;

    public long getStudentid() {
        return studentid;
    }

    public void setStudentid(long studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return studentid == students.studentid && Objects.equals(name, students.name) && Objects.equals(age, students.age) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentid, name, age);
    }

    public List<Books> getBooksByStudentid() {
        return booksByStudentid;
    }

    public void setBooksByStudentid(List<Books> booksByStudentid) {
        this.booksByStudentid = booksByStudentid;
    }

    public List<Notification> getNotificationsByStudentid() {
        return notificationsByStudentid;
    }

    public void setNotificationsByStudentid(List<Notification> notificationsByStudentid) {
        this.notificationsByStudentid = notificationsByStudentid;
    }

    public List<Readinghistory> getReadinghistoriesByStudentid() {
        return readinghistoriesByStudentid;
    }

    public void setReadinghistoriesByStudentid(List<Readinghistory> readinghistoriesByStudentid) {
        this.readinghistoriesByStudentid = readinghistoriesByStudentid;
    }

    public Users getUsersByUserid() {
        return usersByUserid;
    }

    public void setUsersByUserid(Users usersByUserid) {
        this.usersByUserid = usersByUserid;
    }

    public List<Subscriptions> getSubscriptionsByStudentid() {
        return subscriptionsByStudentid;
    }

    public void setSubscriptionsByStudentid(List<Subscriptions> subscriptionsByStudentid) {
        this.subscriptionsByStudentid = subscriptionsByStudentid;
    }
}
