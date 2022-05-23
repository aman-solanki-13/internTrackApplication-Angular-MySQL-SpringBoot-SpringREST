package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assignmentDetails")
public class Assignment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignmentID")
    int assignmentID;

    @Column(name = "assignmentName")
    String assignmentName;

    @Column(name = "givenBy")
    String givenBy;

    @Column(name = "givenTo")
    String givenTo;

    @Column(name = "assignmentStatus")
    String assignmentStatus = "Incomplete";

    @Column(name = "assignmentDateTime")
    String assignmentDateTime;

    public Assignment(String assignmentName, String givenBy, String givenTo, String assignmentDateTime) {
        this.assignmentName = assignmentName;
        this.givenBy = givenBy;
        this.givenTo = givenTo;
        this.assignmentDateTime = assignmentDateTime;
    }

    public Assignment() {
    }

    public String getAssignmentDateTime() {
        return assignmentDateTime;
    }

    public void setAssignmentDateTime(String assignmentDateTime) {
        this.assignmentDateTime = assignmentDateTime;
    }

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }

    public String getGivenTo() {
        return givenTo;
    }

    public void setGivenTo(String givenTo) {
        this.givenTo = givenTo;
    }
}
