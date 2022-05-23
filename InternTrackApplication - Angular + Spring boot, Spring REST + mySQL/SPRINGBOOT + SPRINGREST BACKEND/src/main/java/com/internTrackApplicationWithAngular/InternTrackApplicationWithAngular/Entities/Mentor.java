package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "mentorDetails")
public class Mentor implements Serializable {

    @Id
    @Column(name = "mentorId")
    String mentorId;

    @Column(name = "mentorName")
    String mentorName;

    @Column(name = "mentorPassword")
    String mentorPassword;

    @Column(name = "mentorOf")
    String mentorOf;

    public Mentor(){

    }


    public Mentor(String mentorName, String mentorId, String mentorPassword, String mentorOf) {
        this.mentorName = mentorName;
        this.mentorId = mentorId;
        this.mentorPassword = mentorPassword;
        this.mentorOf = mentorOf;
    }


    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    public String getMentorPassword() {
        return mentorPassword;
    }

    public void setMentorPassword(String mentorPassword) {
        this.mentorPassword = mentorPassword;
    }

    public String getMentorOf() {
        return mentorOf;
    }

    public void setMentorOf(String mentorOf) {
        this.mentorOf = mentorOf;
    }
}

