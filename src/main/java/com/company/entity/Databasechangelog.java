package com.company.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Databasechangelog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "author")
    private String author;
    @Basic
    @Column(name = "filename")
    private String filename;
    @Basic
    @Column(name = "dateexecuted")
    private Timestamp dateexecuted;
    @Basic
    @Column(name = "orderexecuted")
    private int orderexecuted;
    @Basic
    @Column(name = "exectype")
    private String exectype;
    @Basic
    @Column(name = "md5sum")
    private String md5Sum;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "comments")
    private String comments;
    @Basic
    @Column(name = "tag")
    private String tag;
    @Basic
    @Column(name = "liquibase")
    private String liquibase;
    @Basic
    @Column(name = "contexts")
    private String contexts;
    @Basic
    @Column(name = "labels")
    private String labels;
    @Basic
    @Column(name = "deployment_id")
    private String deploymentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Timestamp getDateexecuted() {
        return dateexecuted;
    }

    public void setDateexecuted(Timestamp dateexecuted) {
        this.dateexecuted = dateexecuted;
    }

    public int getOrderexecuted() {
        return orderexecuted;
    }

    public void setOrderexecuted(int orderexecuted) {
        this.orderexecuted = orderexecuted;
    }

    public String getExectype() {
        return exectype;
    }

    public void setExectype(String exectype) {
        this.exectype = exectype;
    }

    public String getMd5Sum() {
        return md5Sum;
    }

    public void setMd5Sum(String md5Sum) {
        this.md5Sum = md5Sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLiquibase() {
        return liquibase;
    }

    public void setLiquibase(String liquibase) {
        this.liquibase = liquibase;
    }

    public String getContexts() {
        return contexts;
    }

    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Databasechangelog that = (Databasechangelog) o;
        return orderexecuted == that.orderexecuted && Objects.equals(id, that.id) && Objects.equals(author, that.author) && Objects.equals(filename, that.filename) && Objects.equals(dateexecuted, that.dateexecuted) && Objects.equals(exectype, that.exectype) && Objects.equals(md5Sum, that.md5Sum) && Objects.equals(description, that.description) && Objects.equals(comments, that.comments) && Objects.equals(tag, that.tag) && Objects.equals(liquibase, that.liquibase) && Objects.equals(contexts, that.contexts) && Objects.equals(labels, that.labels) && Objects.equals(deploymentId, that.deploymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, filename, dateexecuted, orderexecuted, exectype, md5Sum, description, comments, tag, liquibase, contexts, labels, deploymentId);
    }
}
