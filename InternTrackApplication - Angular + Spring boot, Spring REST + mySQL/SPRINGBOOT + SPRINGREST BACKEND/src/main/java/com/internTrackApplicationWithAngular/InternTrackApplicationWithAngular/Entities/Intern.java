package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "internDetails")
public class Intern implements Serializable {
    @Id
    @Column(name = "internId")
    String internId;

    @Column(name = "internName")
    String internName;


    @Column(name = "internPassword")
    String internPassword;

    @Column(name = "internGender")
    String internGender;

    public Intern(){

    }

    public Intern(String internName, String internId, String internPassword, String internGender) {
        this.internName = internName;
        this.internId = internId;
        this.internPassword = internPassword;
        this.internGender = internGender;
    }

    public String getInternName() {
        return internName;
    }

    public void setInternName(String interName) {
        this.internName = interName;
    }

    public String getInternId() {
        return internId;
    }

    public void setInternId(String internId) {
        this.internId = internId;
    }

    public String getInternPassword() {
        return internPassword;
    }

    public void setInternPassword(String interPassword) {
        this.internPassword = interPassword;
    }

    public String getInternGender() {
        return internGender;
    }

    public void setInternGender(String internGender) {
        this.internGender = internGender;
    }


    @Override
    public String toString() {
        return "Intern{" +
                "internName='" + internName + '\'' +
                ", internId='" + internId + '\'' +
                ", internPassword='" + internPassword + '\'' +
                ", internGender='" + internGender + '\'' +
                '}';
    }
}

