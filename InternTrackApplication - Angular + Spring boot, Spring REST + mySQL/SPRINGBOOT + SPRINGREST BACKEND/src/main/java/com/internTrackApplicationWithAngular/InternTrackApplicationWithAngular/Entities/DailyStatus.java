package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dailyStatus")
public class DailyStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StatusId")
    int id;

    @Column(name = "dailyStatus")
    String dailyStatus;

    @Column(name = "statusOf")
    String statusOf;

    @Column(name = "statusDateTIme")
    String statusDateTime;
    public DailyStatus(){

    }

    public DailyStatus(String dailyStatus, String statusOf, String statusDateTime){
        this.dailyStatus = dailyStatus;
        this.statusOf = statusOf;
        this.statusDateTime = statusDateTime;
    }

    public String getStatusDateTime() {
        return statusDateTime;
    }

    public void setStatusDateTime(String statusDateTime) {
        this.statusDateTime = statusDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDailyStatus() {
        return dailyStatus;
    }

    public void setDailyStatus(String dailyStatus) {
        this.dailyStatus = dailyStatus;
    }

    public String getStatusOf() {
        return statusOf;
    }

    public void setStatusOf(String statusOf) {
        this.statusOf = statusOf;
    }
}

