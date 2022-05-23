package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.DailyStatus;

import java.util.List;

public interface dailyStatusService {
    public void addStatus(DailyStatus dailyStatus);
    public List<DailyStatus> listDailyStatusByInternId(String statusOf);
}
