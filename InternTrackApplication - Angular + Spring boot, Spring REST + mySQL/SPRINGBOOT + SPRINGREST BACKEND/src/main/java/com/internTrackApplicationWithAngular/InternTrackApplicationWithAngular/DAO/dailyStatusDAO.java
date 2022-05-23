package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.DailyStatus;

import java.util.List;

public interface dailyStatusDAO {
    public void addStatus(DailyStatus dailyStatus);
    public List<DailyStatus> listDailyStatusByInternId(String statusOf);
}
